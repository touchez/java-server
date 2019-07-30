package com.iotexample.demo.service;

import com.iotexample.demo.dao.ExaminationorderMapper;
import com.iotexample.demo.dao.TreatmentMapper;
import com.iotexample.demo.dao.UserMapper;
import com.iotexample.demo.model.Examinationorder;
import com.iotexample.demo.model.Treatment;
import com.iotexample.demo.model.User;
import com.iotexample.demo.mymapper.MyPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class PayService {

  @Autowired
  UserMapper userMapper;

  @Autowired
  ExaminationorderMapper examinationorderMapper;

  @Autowired
  TreatmentMapper treatmentMapper;

  @Autowired
  MyPayMapper myPayMapper;

  /**
   * @Description: 根据userId和examinationOrderId进行扣款，正常情况返回1，已经付款过了返回-1，余额不足返回-2
   * @Param: [userId, examinationOrderId]
   * @return: int
   * @Author: WenYuan
   * @Date: 2019-06-04
   */
  @Transactional(rollbackFor = Exception.class)
  public int payExaminationOrderByUserIdAndId(long userId, long examinationOrderId) {
    Examinationorder examinationorder = examinationorderMapper.selectByPrimaryKey(examinationOrderId);
    BigDecimal price = examinationorder.getExaminationCost();

    if (examinationorder.getPayState() == 1) {
      //已经付款过了
      return -1;
    }

    int res = myPayMapper.subBalance(userId, price);
    if (res > 0) {
      //余额充足，更新examinationOrder的payState
      int res1 = myPayMapper.payExamination(examinationOrderId);
      if (res1 > 0) {
        return res;
      } else {
        //已经付款过了
        myPayMapper.addBalance(userId, price);
        return -1;
      }
    } else {
      //余额不足
      return -2;
    }
  }

  @Transactional(rollbackFor = Exception.class)
  public int payTreatmentByUserIdAndId(long userId, long treatmentId) {
    Treatment treatment = treatmentMapper.selectByPrimaryKey(treatmentId);
    BigDecimal price = treatment.getTreatmentCost();

    if (treatment.getPayState() == 1) {
      //已经付款过了
      return -1;
    }

    int res = myPayMapper.subBalance(userId, price);
    if (res > 0) {
      //余额充足，更新examinationOrder的payState
      int res1 = myPayMapper.payTreatment(treatmentId);
      if (res1 > 0) {
        return res;
      } else {
        //已经付款过了
        myPayMapper.addBalance(userId, price);
        return -1;
      }
    } else {
      //余额不足
      return -2;
    }
  }
}
