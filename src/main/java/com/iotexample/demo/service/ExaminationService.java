package com.iotexample.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iotexample.demo.dao.CtMapper;
import com.iotexample.demo.dao.ExsanguinateMapper;
import com.iotexample.demo.dao.XrayMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: iotdemo
 * @description: 检查的service
 * @author: WenYuan
 * @create: 2019-06-02 22:32
 **/
@Service
@Slf4j
public class ExaminationService {
  @Autowired
  XrayMapper xrayMapper;

  @Autowired
  CtMapper ctMapper;

  @Autowired
  ExsanguinateMapper exsanguinateMapper;

  public JSON getExaminationByTypeAndId(long examinationId, String examinationType) {
    JSON json = null;
    switch (examinationType) {
      case "xray":
        json = (JSONObject) JSON.toJSON(xrayMapper.selectByPrimaryKey(examinationId));
        break;
      case "ct":
        json = (JSONObject) JSON.toJSON(ctMapper.selectByPrimaryKey(examinationId));
        break;
      case "exsanguinate":
        json = (JSONObject) JSON.toJSON(exsanguinateMapper.selectByPrimaryKey(examinationId));
        break;
      default:
    }
    return json;
  }
}
