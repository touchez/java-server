package com.iotexample.demo.service;

import com.alibaba.fastjson.JSON;
import com.iotexample.demo.config.WXConfig;
import com.iotexample.demo.dao.UserMapper;
import com.iotexample.demo.model.User;
import com.iotexample.demo.model.UserExample;
import com.iotexample.demo.myredis.RedisService;
import com.iotexample.demo.myredis.UserKey;
import com.iotexample.demo.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  @Autowired
  WXConfig wxConfig;

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

  public long getUserByJSCode(String code) {
    RestTemplate restTemplate = new RestTemplate();
    String WX_URL = "https://api.weixin.qq.com/sns/jscode2session";

//    log.info("appid :{}", wxConfig.getAppId());
//    log.info("secret :{}", wxConfig.getAppSecret());

    String res = restTemplate.getForObject(WX_URL + "?appid={1}&secret={2}&js_code={3}&grant_type=authorization_code", String.class,
            wxConfig.getAppId(), wxConfig.getAppSecret(), code);

    LoginVo loginVo = JSON.parseObject(res, LoginVo.class);

    UserExample userExample = new UserExample();
    userExample.createCriteria().andUidEqualTo(loginVo.getOpenid());
    List<User> list = userMapper.selectByExample(userExample);
    long userId = -1;
    if (list.size() == 0) {
      //插入用户
      User user = new User().withUid(loginVo.getOpenid());
      userMapper.insertSelective(user);
      userId = user.getUserId();
    }else {
      userId = list.get(0).getUserId();
    }

//    log.info("get sth {}", JSON.toJSONString(loginVo));

    return userId;
  }
}
