package com.iotexample.demo.controller;

//
//import com.iotexample.demo.model.Doctor;
//import com.iotexample.demo.model.Guahao;
//import com.iotexample.demo.model.Jiuzhen;
//import com.iotexample.demo.result.CodeMsg;
//import com.iotexample.demo.result.Result;
//import com.iotexample.demo.service.DoctorService;
//import com.iotexample.demo.service.GuahaoService;
//import com.iotexample.demo.service.JianchaorderService;
//import com.iotexample.demo.service.JiuzhenService;
//import com.iotexample.demo.validator.NeedGuahao;
//import com.iotexample.demo.vo.JiuzhenVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//
///**
// * @program: iotdemo
// * @description: 就诊界面的controller
// * @author: WenYuan
// * @create: 2019-05-23 16:33
// **/
//
//@RestController
//@RequestMapping("/jiuzhen")
public class JiuzhenController {
//  @Autowired
//  JiuzhenService jiuzhenService;
//
//  @Autowired
//  DoctorService doctorService;
//
//  @Autowired
//  JianchaorderService jianchaorderService;
//
//  @Autowired
//  GuahaoService guahaoService;
//
//  /**
//   * @Description: 前端提交页面，将数据放入数据库中
//   * @Param: [jiuzhenVo] body中的内容类似下面
//   *
//   * {
//   * "doctorId":"4",
//   * "doctorName":"doctor D",
//   * "guahaoId":"3",
//   * "userId":"1",
//   * "jiuzhenContent":"fst's brain has very big problem", //前四个直接加到jiuzhen表中
//   * "jianchaIds":["3","5"], //后面这个逐条加入jianchaorder表中
//   * }
//   *
//   * @return: com.iotexample.demo.result.Result<com.iotexample.demo.vo.JiuzhenVo>
//   * @Author: WenYuan
//   * @Date: 2019/5/23
//   */
//  @PostMapping
//  public Result<JiuzhenVo> first(@RequestBody JiuzhenVo jiuzhenVo) {
//    //增加就诊记录
//    long jiuzhenId = jiuzhenService.addJiuzhen(jiuzhenVo);
//    //增加检查项目记录
//    int res2 = jianchaorderService.addAll(jiuzhenVo, jiuzhenId);
//    //更新挂号结束时间
//    int res3 = guahaoService.updateEndDate(jiuzhenVo.getGuahaoId());
//    if (res2 > 0 && res3 > 0) {
//      return Result.success(jiuzhenVo);
//    }
//
//    return Result.error(CodeMsg.DB_ERROR);
//  }
//
//  @GetMapping("/doctorName")
//  @NeedGuahao
//  public Result<String> getDoctorName(HttpSession session) {
//    //TODO 根据cookie来获得医生姓名，考虑用什么参数适合
//    Guahao guahao = (Guahao) session.getAttribute("guahao");
//
//    long doctorId = guahao.getDoctorId();
//    Doctor doctor = doctorService.getById(doctorId);
//    String doctorName = doctor.getDoctorName();
//
//    return Result.success(doctorName);
//  }
//
}
