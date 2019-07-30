package com.iotexample.demo.myredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @program: iotdemo
 * @description: 存放jedis的pool
 * @author: WenYuan
 * @create: 2019-07-19 10:37
 */

public class RedisPool {

  private JedisPool jedisPool;
  private int retryCount;

  public RedisPool() {
    this.jedisPool = new JedisPool();
    this.retryCount = 0;
  }

  public RedisPool(int retryCount) {
    this.retryCount = retryCount;
  }

  public void execute(CallWithJedis callWithJedis) {
    //通过try resource机制来保证jedis可以顺利返回jedispool

    Jedis jedis = jedisPool.getResource();

    try {
      callWithJedis.call(jedis);
    } catch (JedisConnectionException e) {
      //根据参数设置重置多少次
      int i = retryCount;

      while (i-- > 0) {
        try{
          callWithJedis.call(jedis);
        } catch (JedisConnectionException e1) {
          continue;
        }
        //没被catch就说明执行成功了
        break;
      }
    } finally{
      jedis.close();
    }

  }

}
