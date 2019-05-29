package com.iotexample.demo.myredis;

/**
 * @program: iotdemo
 * @description: 挂号信息存储的key
 * @author: WenYuan
 * @create: 2019-05-29 20:53
 **/

public class GuahaoKey extends BasePrefix {
  private static final int EXPIRE_SECONDS = 10 * 60;
  private GuahaoKey(int expireSeconds, String prefix) {
    super(expireSeconds, prefix);
  }

  public static GuahaoKey token = new GuahaoKey(EXPIRE_SECONDS, "id");
  public static GuahaoKey getById = new GuahaoKey(EXPIRE_SECONDS, "Name");
}
