package com.iotexample.demo.websocketio;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: iotdemo
 * @description: 服务启动时启动socketio
 * @author: WenYuan
 * @create: 2019-07-31 10:05
 */

@Component
@Order(value = 1)
@Slf4j
public class ServerRunner implements CommandLineRunner {

  private final SocketIOServer socketIOServer;

  @Autowired
  public ServerRunner(SocketIOServer server) {
    this.socketIOServer = server;
  }

  @Override
  public void run(String... args) throws Exception {
    socketIOServer.start();
    log.info("socket.io 启动成功");
  }
}
