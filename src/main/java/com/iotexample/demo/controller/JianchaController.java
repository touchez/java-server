package com.iotexample.demo.controller;

import com.iotexample.demo.model.Guahao;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.JianchaService;
import com.iotexample.demo.service.JianchaorderService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @program: iotdemo
 * @description: 检查项目controller
 * @author: WenYuan
 * @create: 2019-05-23 17:36
 **/
@RequestMapping("/jiancha")
@Controller
@Slf4j
public class JianchaController {
  @Autowired
  JianchaService jianchaService;

  @Autowired
  JianchaorderService jianchaorderService;


  /**
  * @Description: 去检查项目那里触碰排队时的接口，返回排队人数
   *
   * 例子:
   *
   *
  * @Param: [session, jianchaId] 需要在参数中加上jianchaId
  * @return: com.iotexample.demo.result.Result<java.lang.Long>
  * @Author: WenYuan
  * @Date: 2019/5/23
  */
  @RequestMapping("/ready")
  @ResponseBody
  public Result<Long> ready(HttpSession session, @RequestParam("jianchaId")long jianchaId) {
    Guahao guahao = (Guahao) session.getAttribute("guahao");
    //userId从session中获得，jianchaId从参数中获得（参数可以存在nfc标签中）
    if (guahao == null) {
      return Result.error(CodeMsg.SESSION_ERROR);
    }
    long userId = guahao.getUserId();

    long count = jianchaorderService.getWaittingCount(userId, jianchaId);

    if (count == -1) {
      log.info("userId is {}", userId);
      return Result.error(CodeMsg.CHECK_ERROR);
    }

    //轮到这个人检查了
    if (count == 0) {
      jianchaorderService.updateState(userId, jianchaId);
    }

    return Result.success(count);
  }

  /**
  * @Description: 测试用，检查下一个人
  * @Param: []
  * @return: com.iotexample.demo.result.Result<java.lang.Long>
  * @Author: WenYuan
  * @Date: 2019/5/23
  */
  @RequestMapping("/checknext")
  @ResponseBody
  public Result<Long> checknext(@RequestParam("jianchaId")long jianchaId) {
    long jianchaorderId = jianchaorderService.checkNext(jianchaId);

    return Result.success(jianchaorderId);
  }

}
