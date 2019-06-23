package com.iotexample.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iotexample.demo.dao.CtMapper;
import com.iotexample.demo.dao.ExsanguinateMapper;
import com.iotexample.demo.dao.XrayMapper;
import com.iotexample.demo.model.*;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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

  public JSONObject getExaminationByTypeAndId(long examinationId, String examinationType) {
    JSONObject json = null;
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

  public JSON getAllExamination() {

    HashMap<String, Object> map = new HashMap<>();


    XrayExample xrayExample = new XrayExample();
    xrayExample.createCriteria();
    List<Xray> xrayList = xrayMapper.selectByExample(xrayExample);

    CtExample ctExample = new CtExample();
    ctExample.createCriteria();
    List<Ct> ctList = ctMapper.selectByExample(ctExample);

    ExsanguinateExample exsanguinateExample = new ExsanguinateExample();
    exsanguinateExample.createCriteria();
    List<Exsanguinate> exsanguinateList = exsanguinateMapper.selectByExample(exsanguinateExample);

    map.put("xray", xrayList);
    map.put("ct", ctList);
    map.put("exsanguinate", exsanguinateList);

    String str = JSON.toJSONString(map);
    JSON json = JSON.parseObject(str);

    return json;
  }

  //返回主键的值
  public long insertExamnaitons(ExaminationType examinationType, Long userId) {
    String type = examinationType.getExaminationTypeName();

    long examinationId = 0;

    switch (type) {
      case "ct":
        Ct ct = new Ct()
                .withCtAddr(examinationType.getExaminationAddr())
                .withCtCost(examinationType.getExaminationCost())
                .withCtPart(examinationType.getExaminationTypeDetail())
                .withUserId(userId);

        int res = ctMapper.insertSelective(ct);

        examinationId = ct.getCtId();
        break;
      case "xray":
        Xray xray = new Xray()
                .withXrayAddr(examinationType.getExaminationAddr())
                .withXrayCost(examinationType.getExaminationCost())
                .withXrayPart(examinationType.getExaminationTypeDetail())
                .withUserId(userId);

        int res1 = xrayMapper.insertSelective(xray);

        examinationId = xray.getXrayId();
        break;
      case "exsanguinate":
        Exsanguinate exsanguinate = new Exsanguinate()
                .withExsanguinateAddr(examinationType.getExaminationAddr())
                .withExsanguinateCost(examinationType.getExaminationCost())
                .withUserId(userId);

        int res2 = exsanguinateMapper.insertSelective(exsanguinate);

        examinationId = exsanguinate.getExsanguinateId();
        break;

      default:
        log.info("error type");
        break;
    }

    return examinationId;
  }
}
