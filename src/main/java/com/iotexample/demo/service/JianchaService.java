package com.iotexample.demo.service;

import com.iotexample.demo.dao.JianchaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: iotdemo
 * @description: 检查项目service
 * @author: WenYuan
 * @create: 2019-05-23 17:35
 **/

@Service
public class JianchaService {
  @Autowired
  JianchaMapper jianchaMapper;
}
