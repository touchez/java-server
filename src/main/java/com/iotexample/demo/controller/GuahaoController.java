package com.iotexample.demo.controller;

import com.iotexample.demo.model.Guahao;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.DoctorService;
import com.iotexample.demo.service.GuahaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @program: iotdemo
 * @description: 用于挂号的controller
 * @author: WenYuan
 * @create: 2019-05-23 10:34
 **/

@RequestMapping("/guahao")
@Controller
public class GuahaoController {

  @Autowired
  GuahaoService guahaoService;

  @Autowired
  DoctorService doctorService;


  /**
  * @Description:  根据参数添加挂号
  * @Param: 例子：http://localhost:8080/guahao/insert?userId=2&departmentId=1
  * @return: 自增的主键guahaoId的值
  * @Author: WenYuan
  * @Date: 2019/5/23
  */
  @RequestMapping("/insert")
  @ResponseBody
  public Result<Guahao> guahao(HttpSession session, @RequestParam("userId")long userId,
                               @RequestParam("departmentId")long departmentId,
                               @RequestParam(value = "doctorId", defaultValue = "0")long doctorId) {
    if (doctorId == 0) {
      //如果没有指定doctorId则从该科室选一个doctor出来
      doctorId = doctorService.getOneByDepartment(departmentId);
    }

    try {
      Guahao guahao = guahaoService.guahao(userId, departmentId, doctorId);
      session.setAttribute("guahao", guahao);

      return Result.success(guahao);
    } catch (DuplicateKeyException e) {
      return Result.error(CodeMsg.DUPLICATE_ERROR);
    }
  }

  /**
  * @Description:  获取前面还有多少人
  * @Param: [guahaoId] http://localhost:8080/guahao/getOrder?guahaoId=7
  * @return: long 前面的人数
  * @Author: WenYuan
  * @Date: 2019/5/23
  */
  @RequestMapping("/getOrder")
  @ResponseBody
  public Result<Long> getOrder(HttpSession session,
                       @RequestParam(value = "guahaoId", defaultValue = "-1")long guahaoId) {
    Guahao guahao = (Guahao) session.getAttribute("guahao");

    if (guahao != null) {
      guahaoId = guahao.getGuahaoId();
    }

    long order = guahaoService.getOrderByGuahaoId(guahaoId);
    return Result.success(order);
  }
}
