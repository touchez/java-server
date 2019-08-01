package com.iotexample.demo.controller;

import com.iotexample.demo.websocketio.MessageEventHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: iotdemo
 * @description: 用来测试的controller
 * @author: WenYuan
 * @create: 2019-07-31 14:48
 */
@RequestMapping("/api/test")
@RestController
@CrossOrigin
public class TestController {

  @GetMapping("/1")
  public boolean test1() {
    MessageEventHandler.sendById("1", "hello");

    return true;
  }

}
