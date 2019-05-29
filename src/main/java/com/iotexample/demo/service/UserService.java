package com.iotexample.demo.service;

import com.iotexample.demo.dao.UserMapper;
import com.iotexample.demo.model.User;
import com.iotexample.demo.model.UserExample;
import com.iotexample.demo.myredis.RedisService;
import com.iotexample.demo.myredis.UserKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iotdemo
 * @description: user service
 * @author: WenYuan
 * @create: 2019-05-22 23:06
 **/

@Service
@Slf4j
public class UserService {
  public static final String COOKIE_NAME_TOKEN = "token";

  @Autowired
  UserMapper userMapper;

  @Autowired
  RedisService redisService;

  public List<User> listUser() {
    UserExample userExample = new UserExample();
    UserExample.Criteria criteria = userExample.createCriteria();
    criteria.andUserIdIsNotNull();

    List<User>list = userMapper.selectByExample(userExample);
    list.forEach(e -> log.info("select by example {}", e));

    return list;
  }

  public long getByToken(String token) {
    if (StringUtils.isEmpty(token)) {
      return -1;
    }

    Long userId = redisService.get(UserKey.token, token, Long.class);

    return userId;
  }

}
