package com.iotexample.demo.controller;

import com.iotexample.demo.model.User;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: iotdemo
 * @description: user controller
 * @author: WenYuan
 * @create: 2019-05-22 23:08
 **/

@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping("/info")
  @ResponseBody
  public Result<List<User>> info(Model model) {
    log.info("enter /user/info");
    List<User> userList = userService.listUser();
    //String jsonString = JSON.toJSONString(userList);
    return Result.success(userList);
  }
}
