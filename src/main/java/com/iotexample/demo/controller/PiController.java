package com.iotexample.demo.controller;

import com.iotexample.demo.myredis.RedisService;
import com.iotexample.demo.myredis.UserKey;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.websocketio.GPSMessage;
import com.iotexample.demo.websocketio.MessageEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiController {
  @Autowired
  RedisService redisService;

  @GetMapping("/api/v1/openlock")
  public Result<String> openLock(@RequestParam(defaultValue = "树莓派1号") String userId) {
    MessageEventHandler.remoteOpenLockById(userId, "这个暂时没用，随便填");
    return Result.success("success");
  }

  @GetMapping("/api/v1/gps")
  public Result<GPSMessage> getGPSInfo(@RequestParam(defaultValue = "树莓派1号") String userId) {
    GPSMessage msg = redisService.get(UserKey.gps_loc, userId, GPSMessage.class);
    return Result.success(msg);
  }
}
