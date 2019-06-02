package com.iotexample.demo.controller;
//
//import com.iotexample.demo.model.Guahao;
//import com.iotexample.demo.model.Jiancha;
//import com.iotexample.demo.model.Jianchaorder;
//import com.iotexample.demo.result.CodeMsg;
//import com.iotexample.demo.result.Result;
//import com.iotexample.demo.service.JianchaService;
//import com.iotexample.demo.service.JianchaorderService;
//import com.iotexample.demo.vo.RequestJianchaVo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
///**
// * @program: iotdemo
// * @description: 检查项目controller
// * @author: WenYuan
// * @create: 2019-05-23 17:36
// **/
//@RequestMapping("/jiancha")
//@RestController
//@Slf4j
public class JianchaController {
//  @Autowired
//  JianchaService jianchaService;
//
//  @Autowired
//  JianchaorderService jianchaorderService;
//
//
//  /**
//  * @Description: 去检查项目那里触碰排队时的接口，返回排队人数
//   *
//   * 例子:
//   *
//   *
//  * @Param: [session, jianchaId] 需要在参数中加上jianchaId
//  * @return: com.iotexample.demo.result.Result<java.lang.Long>
//  * @Author: WenYuan
//  * @Date: 2019/5/23
//  */
//  @PostMapping
//  public Result<Long> ready(HttpSession session, @RequestBody RequestJianchaVo requestJianchaVo) {
////    Guahao guahao = (Guahao) session.getAttribute("guahao");
////    //userId从session中获得，jianchaId从参数中获得（参数可以存在nfc标签中）
////    if (guahao == null) {
////      return Result.error(CodeMsg.SESSION_ERROR);
////    }
//    //long userId = guahao.getUserId();
//
//    long userId = requestJianchaVo.getUserId();
//    long jianchaId = requestJianchaVo.getJianchaId();
//
//    long count = jianchaorderService.getWaittingCount(userId, jianchaId);
//
//    //无法获取到检查条目，应该是去了错误的检查地点
//    if (count == -1) {
//      log.info("userId is {}", userId);
//      return Result.error(CodeMsg.CHECK_ERROR);
//    }
//
//    //轮到这个人检查了
//    if (count == 0) {
//      jianchaorderService.updateState(userId, jianchaId);
//    }
//
//    return Result.success(count);
//  }
//
//  /**
//  * @Description: 测试用，检查下一个人
//  * @Param: []
//  * @return: com.iotexample.demo.result.Result<java.lang.Long>
//  * @Author: WenYuan
//  * @Date: 2019/5/23
//  */
//  @PutMapping
//  public Result<Long> checknext(@RequestParam("jianchaId")long jianchaId) {
//    long jianchaorderId = jianchaorderService.checkNext(jianchaId);
//
//    return Result.success(jianchaorderId);
//  }
//
//  /**
//  * @Description: 根据userId获取所有待做的检查项目
//  * @Param: [str]
//  * @return: com.iotexample.demo.result.Result<java.util.List<com.iotexample.demo.model.Jianchaorder>>
//  * @Author: WenYuan
//  * @Date: 2019/6/2
//  */
//  @GetMapping("/{userId}")
//  public Result<List<Jianchaorder>> getJiancha(@PathVariable("userId")String str) {
//    long userId = -1;
//    if (str != null) {
//      userId = Long.parseLong(str);
//    }
//    List<Jianchaorder> list = jianchaorderService.getJianchaByUserId(userId);
//    return Result.success(list);
//  }
//
}
