package com.iotexample.demo.websocketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.iotexample.demo.myredis.RedisService;
import com.iotexample.demo.myredis.UserKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: iotdemo
 * @description: 处理连接事件
 * @author: WenYuan
 * @create: 2019-07-31 10:20
 */

@Component
@Slf4j
public class MessageEventHandler {

  @Autowired
  RedisService redisService;

  public static SocketIOServer socketIOServer;

  // userId -> socketIO client Id
  private static ConcurrentHashMap<String, UUID> clientMap = new ConcurrentHashMap<>();


  @Autowired
  public MessageEventHandler(SocketIOServer server) {
    socketIOServer = server;
  }

  /**
   * 客户端连接的时候触发
   * @param client
   */

  @OnConnect
  public void onConnect(SocketIOClient client) {
    String userId = client.getHandshakeData().getSingleUrlParam("userId");

    clientMap.put(userId, client.getSessionId());

    //socketIoServer.getClient(client.getSessionId()).sendEvent("message", "back data");

    log.info("客户端 : {} 用户 {} 已连接", client.getSessionId(), userId);
  }

  /**
   * 客户端关闭连接时触发：前端js触发：socket.disconnect();
   * @param client
   */

  @OnDisconnect
  public void onDisConnect(SocketIOClient client) {
    String userId = client.getHandshakeData().getSingleUrlParam("userId");
    clientMap.remove(userId);

    log.info("客户端 {} 用户 {} 断开连接", client.getSessionId(), userId);
  }

  /**
   * 自定义消息事件，客户端js触发：socket.emit('messageevent', {msgContent: msg}); 时触发
   * 前端js的 socket.emit("事件名","参数数据")方法，是触发后端自定义消息事件的时候使用的,
   * 前端js的 socket.on("事件名",匿名函数(服务器向客户端发送的数据))为监听服务器端的事件
   * @param client　客户端信息
   * @param request 请求信息
   * @param data　客户端发送数据{msgContent: msg}
   */
  @OnEvent(value = "messageevent")
  public void onEvent(SocketIOClient client, AckRequest request, MessageInfo data) {
    System.out.println("发来消息：" + data);
    //服务器端向该客户端发送消息
    //socketIoServer.getClient(client.getSessionId()).sendEvent("messageevent", "你好 data");
    client.sendEvent("messageevent","我是服务器都安发送的信息");
  }

  @OnEvent(value = "gps")
  public void onGPSEvent(SocketIOClient client, AckRequest request, GPSMessage data) {
    log.info("gps发来消息：" + data);
    String userId = client.getHandshakeData().getSingleUrlParam("userId");
    //服务器端向该客户端发送消息
    //socketIoServer.getClient(client.getSessionId()).sendEvent("messageevent", "你好 data");
    client.sendEvent("messageevent","gps位置为" + data);
    redisService.set(UserKey.gps_loc, userId, data);
  }

  public static void sendById(String userId, String message) {   //这里就是向客户端推消息了
    socketIOServer.getClient(clientMap.get(userId)).sendEvent("jump", message);
    log.info("发送消息给 {} 消息是 {}", userId, message);
  }

  public static void remoteOpenLockById(String userId, String message) {   //这里就是向客户端推消息了
    log.info("获取client{}", clientMap.get(userId));
    socketIOServer.getClient(clientMap.get(userId)).sendEvent("openlock", message);
    log.info("发送消息给 {} 消息是 {}", userId, message);
  }
}
