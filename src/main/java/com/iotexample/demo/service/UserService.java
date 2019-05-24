package com.iotexample.demo.service;

import com.iotexample.demo.dao.UserMapper;
import com.iotexample.demo.model.User;
import com.iotexample.demo.model.UserExample;
import lombok.extern.slf4j.Slf4j;
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
  @Autowired
  UserMapper userMapper;

  public List<User> listUser() {
    UserExample userExample = new UserExample();
    UserExample.Criteria criteria = userExample.createCriteria();
    criteria.andUserIdIsNotNull();

    List<User>list = userMapper.selectByExample(userExample);
    list.forEach(e -> log.info("select by example {}", e));

    return list;
  }

}
