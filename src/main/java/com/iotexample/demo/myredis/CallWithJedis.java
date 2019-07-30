package com.iotexample.demo.myredis;

import redis.clients.jedis.Jedis;

/**
 * 获取jedis时的回调函数
 */
public interface CallWithJedis {
  public void call(Jedis jedis);
}
