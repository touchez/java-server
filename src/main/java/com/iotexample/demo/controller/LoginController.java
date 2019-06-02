package com.iotexample.demo.controller;

import com.alibaba.fastjson.JSON;
import com.iotexample.demo.model.User;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.UserService;
import com.iotexample.demo.vo.LoginVo;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: iotdemo
 * @description: 登录模块
 * @author: WenYuan
 * @create: 2019-06-02 10:59
 **/

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
  @Autowired
  UserService userService;

  @GetMapping
  public Result<Long> login(@RequestParam("code") String code) {
    log.info("login info :{}", code);
    long userId = userService.getUserByJSCode(code);
    return Result.success(userId);
  }
}
