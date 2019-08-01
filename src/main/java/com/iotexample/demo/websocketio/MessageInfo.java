package com.iotexample.demo.websocketio;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @program: iotdemo
 * @description: 接收socketIO消息的类
 * @author: WenYuan
 * @create: 2019-07-31 10:37
 */

@Component
@Data
public class MessageInfo {
  String msgContent;
}
