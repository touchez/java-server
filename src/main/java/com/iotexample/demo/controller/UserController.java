package com.iotexample.demo.controller;

import com.iotexample.demo.model.User;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: iotdemo
 * @description: user controller
 * @author: WenYuan
 * @create: 2019-05-22 23:08
 **/

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping("/info")
  public Result<List<User>> info(Model model) {
    log.info("enter /user/info");
    List<User> userList = userService.listUser();
    //String jsonString = JSON.toJSONString(userList);
    return Result.success(userList);
  }

  @PutMapping("/{userId}")
  public Result<Long> updateUser(@PathVariable("userId") String str, @RequestBody User user) {
    long userId = Long.parseLong(str);
    //TODO 修改用户信息
    return Result.success(0L);
  }

}
