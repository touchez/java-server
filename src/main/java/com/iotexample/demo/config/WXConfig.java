package com.iotexample.demo.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: iotdemo
 * @description: 微信小程序相关参数
 * @author: WenYuan
 * @create: 2019-06-02 13:30
 **/
@Component
@ConfigurationProperties(prefix = "wx")
@Getter
@Setter
public class WXConfig {
  private String appId;
  private String appSecret;
}
