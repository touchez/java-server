package com.iotexample.demo.controller;

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
  public Result<Guahao> guahao(HttpServletResponse response, @RequestBody GuahaoVo guahaoVo, @CookieValue(value = "token", required = false) String token) {
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

      return Result.success(guahao);
    } catch (DuplicateKeyException e) {

      return Result.error(CodeMsg.DUPLICATE_ERROR);
    }
  }

  /** 
  * @Description: 获取用户的所有挂号
  * @Param: [token] 
  * @return: com.iotexample.demo.result.Result<java.util.List<com.iotexample.demo.model.Guahao>> 
  * @Author: WenYuan
  * @Date: 2019/5/29 
  */
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
}
