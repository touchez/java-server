package com.iotexample.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iotexample.demo.RequestEntity.RequestAddExaminationOrder;
import com.iotexample.demo.dao.ExaminationorderMapper;
import com.iotexample.demo.exception.GlobalException;
import com.iotexample.demo.model.Examinationorder;
import com.iotexample.demo.model.ExaminationorderExample;
import com.iotexample.demo.result.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 检查流水的服务
 * @author: WenYuan
 * @create: 2019-06-02 22:12
 **/
@Service
@Slf4j
public class ExaminationOrderService {
  @Autowired
  ExaminationorderMapper examinationorderMapper;

  @Autowired
  ExaminationService examinationService;


  public List<Examinationorder> getAllExaminationOrderByMedicalRecordId(long medicalRecordId) {
    ExaminationorderExample examinationorderExample = new ExaminationorderExample();
    examinationorderExample.createCriteria()
            .andMedicalrecordIdEqualTo(medicalRecordId);

    List<Examinationorder> list = examinationorderMapper.selectByExample(examinationorderExample);
    return list;
  }

  public Examinationorder getExaminationOrderById(long examinationOrderId) {
    Examinationorder examinationorder = examinationorderMapper.selectByPrimaryKey(examinationOrderId);
    return examinationorder;
  }

  public List<Examinationorder> getExaminationOrderByUserIdAndPayState(long userId, int payState) {
    ExaminationorderExample examinationorderExample = new ExaminationorderExample();
    examinationorderExample.createCriteria()
            .andUserIdEqualTo(userId)
            .andPayStateEqualTo(payState);

    List<Examinationorder> list = examinationorderMapper.selectByExample(examinationorderExample);
    return list;
  }

  public int addAllExamination(RequestAddExaminationOrder[] requestAddExaminationOrders) {
    for (RequestAddExaminationOrder requestAddExaminationOrder : requestAddExaminationOrders) {
      Long examinationId = requestAddExaminationOrder.getExaminationId();
      String type = requestAddExaminationOrder.getExaminationType();

      JSON json = examinationService.getExaminationByTypeAndId(examinationId, type);
      JSONObject jsonObject = (JSONObject) json;
      BigDecimal cost = jsonObject.getBigDecimal(type + "Cost");

      Examinationorder examinationorder = new Examinationorder()
              .withUserId(requestAddExaminationOrder.getUserId())
              .withMedicalrecordId(requestAddExaminationOrder.getMedicalRecordId())
              .withExaminationType(requestAddExaminationOrder.getExaminationType())
              .withExaminationId(requestAddExaminationOrder.getExaminationId())
              .withPayState(0)
              .withExaminationCost(cost);

      int res = examinationorderMapper.insert(examinationorder);
      if (res != 1) {
        throw new GlobalException(CodeMsg.DB_ERROR);
      }
    }
    return 0;
  }
}
