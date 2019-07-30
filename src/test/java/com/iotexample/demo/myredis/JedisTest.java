package com.iotexample.demo.myredis;

import org.springframework.boot.autoconfigure.cache.CacheProperties;

/**
 * @program: iotdemo
 * @description: 测试jedis封装成的redispool的使用问题
 * @author: WenYuan
 * @create: 2019-07-19 10:46
 */

public class JedisTest {

  public static void main(String[] args) {
    RedisPool redisPool = new RedisPool();

    Holder<Long> counterHolder = new Holder<>();

    redisPool.execute(jedis -> {
      long count = jedis.zcard("abc");
      counterHolder.setValue(count);
    });

    System.out.print(counterHolder.getValue());

  }
}
