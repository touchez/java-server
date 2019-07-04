package com.iotexample.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iotexample.demo.ResponseEntity.ResponseGuahaoWithOrder;
import com.iotexample.demo.model.Guahao;
import com.iotexample.demo.myredis.GuahaoKey;
import com.iotexample.demo.myredis.RedisService;
import com.iotexample.demo.myredis.UserKey;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.DoctorService;
import com.iotexample.demo.service.GuahaoService;
import com.iotexample.demo.service.UserService;
import com.iotexample.demo.util.UUIDUtil;
import com.iotexample.demo.validator.NeedGuahao;
import com.iotexample.demo.vo.GuahaoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 用于挂号的controller
 * @author: WenYuan
 * @create: 2019-05-23 10:34
 **/

@RequestMapping("/guahao")
@RestController
public class GuahaoController {

  public static final String COOKIE_NAME_TOKEN = "token";

  @Autowired
  RedisService redisService;

  @Autowired
  GuahaoService guahaoService;

  @Autowired
  DoctorService doctorService;

  @Autowired
  UserService userService;


  /**
  * @Description:  根据参数添加挂号
  * @Param: 例子：http://localhost:8080/guahao
  * @return: 自增的主键guahaoId的值
  * @Author: WenYuan
  * @Date: 2019/5/23
  */
  @PostMapping
  @CrossOrigin
  public Result<JSONObject> guahao(HttpServletResponse response, @RequestBody GuahaoVo guahaoVo, @CookieValue(value = "token", required = false) String token) {
    long userId = guahaoVo.getUserId();
    long departmentId = guahaoVo.getDepartmentId();
    long doctorId = guahaoVo.getDoctorId();
    if (doctorId == 0) {
      //如果没有指定doctorId则从该科室选一个doctor出来
      doctorId = doctorService.getOneByDepartment(departmentId);
    }

    try {
      Guahao guahao = guahaoService.guahao(userId, departmentId, doctorId);
      //session.setAttribute("userId", userId);

      //如果没有cookie
      if (token == null) {
        token = UUIDUtil.uuid();
        addCookie(response, token, userId);
      }else {
        //如果之前有cookie还重新登录了，就要更新cookie
        updateCookie(response, token, userId);
      }

      String str = JSON.toJSONString(guahao);

      JSONObject json = JSONObject.parseObject(str);

      json.put("order", guahaoService.getOrderByGuahaoId(guahao.getGuahaoId()));

      return Result.success(json);
    } catch (DuplicateKeyException e) {

      return Result.error(CodeMsg.DUPLICATE_ERROR);
    }
  }

  @GetMapping("/{userId}")
  //@NeedGuahao
  public Result<List<Guahao>> getGuahao(@CookieValue(value = "token", required = false) String token, @PathVariable("userId") String str) {
    long userId = -1;
    if (token != null) {
      userId = userService.getByToken(token);
    }
    if (str != null) {
      userId = Long.parseLong(str);
    }
    List<Guahao> list = guahaoService.getGuahao(userId);
    return Result.success(list);
  }

  /**
  * @Description:  获取前面还有多少人
  * @Param: [guahaoId] http://localhost:8080/guahao/getOrder?guahaoId=7
  * @return: long 前面的人数
  * @Author: WenYuan
  * @Date: 2019/5/23
  */
  @GetMapping("/order")
  @NeedGuahao
  public Result<Long> getOrder(@RequestParam(value = "guahaoId", defaultValue = "-1")long guahaoId) {
    long order = guahaoService.getOrderByGuahaoId(guahaoId);
    return Result.success(order);
  }

  private void addCookie(HttpServletResponse response, String token, long userId) {
    // generate cookie
    redisService.set(UserKey.token, token, userId);
    Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
    cookie.setMaxAge(UserKey.token.expireSeconds());
    cookie.setPath("/");
    response.addCookie(cookie);
  }

  private void updateCookie(HttpServletResponse response, String token, long userId) {
    // generate cookie
    redisService.delete(UserKey.token, token);

    token = UUIDUtil.uuid();
    redisService.set(UserKey.token, token, userId);

    Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
    cookie.setMaxAge(UserKey.token.expireSeconds());
    cookie.setPath("/");
    response.addCookie(cookie);
  }

  /**
  * @Description: 根据userId返回用户的所有active的挂号消息并且按order排序
  * @Param: [userId]
  * @return: com.iotexample.demo.result.Result<java.util.List<com.iotexample.demo.ResponseEntity.ResponseGuahaoWithOrder>>
  * @Author: WenYuan
  * @Date: 2019-06-04
  */
  @GetMapping("/active")
  public Result<List<ResponseGuahaoWithOrder>> getAllActive(@RequestParam("userId")long userId) {
    List<ResponseGuahaoWithOrder> list = guahaoService.getActiveGuahaoOrderByTime(userId);
    return Result.success(list);
  }

  /**
  * @Description: 根据userId和departmentId和doctorId来获得详细挂号信息。返回值里面的order表示前面还有几人
  * @Param: [userId, departmentId, doctorId]
  * @return: com.iotexample.demo.result.Result<com.iotexample.demo.ResponseEntity.ResponseGuahaoWithOrder>
  * @Author: WenYuan
  * @Date: 2019/6/29
  */
  @GetMapping
  @CrossOrigin
  public Result<ResponseGuahaoWithOrder> getGuaHaoDetail(@RequestParam("userId") long userId, @RequestParam("departmentId") long departmentId) {
    ResponseGuahaoWithOrder responseGuahaoWithOrder = guahaoService.getGuahaoDetail(userId, departmentId);
    return Result.success(responseGuahaoWithOrder);
  }


  /** 
  * @Description: 根据userId去删除对应的挂号信息 
  * @Param: [userId] 
  * @return: com.iotexample.demo.result.Result<java.lang.String> 
  * @Author: WenYuan
  * @Date: 2019/7/3 
  */
  @DeleteMapping
  @CrossOrigin
  public Result<String> deleteGuahao(@RequestParam("userId") long userId) {
    int res = guahaoService.deleteGuahaoByUserId(userId);
    
    return Result.success("success");
  }
}
