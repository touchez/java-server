package com.iotexample.demo.websocketio;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @program: iotdemo
 * @description: connect时使用的类
 * @author: WenYuan
 * @create: 2019-07-31 10:40
 */

@Component
@Data
public class ConnectMessge {
  private Long userId;
}
