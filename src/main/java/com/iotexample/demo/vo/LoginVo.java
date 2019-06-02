package com.iotexample.demo.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: iotdemo
 * @description: 接收登录消息
 * @author: WenYuan
 * @create: 2019-06-02 11:02
 **/

@Data
public class LoginVo {
  private String openid;
  private String session_key;
  private String unionid;
  private int errcode;
  private String errmsg;
}