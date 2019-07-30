package com.iotexample.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
public class SessionConfig {
  //冒号后面的值是没有配置文件时自动装载的值
  @Value("${spring.redis.host:localhost}")
  private String hostName;
  @Value("${spring.redis.port:6379}")
  private int port;
  @Value("${spring.redis.password:null}")
  private String password;

  @Bean
  public JedisConnectionFactory connectionFactory() {
    JedisConnectionFactory connection = new JedisConnectionFactory();
    connection.setPort(port);
    connection.setHostName(hostName);
    if (password != null && !"null".equals(password)) {
      connection.setPassword(password);
    }
    connection.setDatabase(0);
    return connection;
  }
}
