package com.iotexample.demo.service;

import com.iotexample.demo.dao.GuahaoMapper;
import com.iotexample.demo.model.Guahao;
import com.iotexample.demo.model.GuahaoExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 用于挂号操作的service
 * @author: WenYuan
 * @create: 2019-05-23 09:59
 **/

@Service
@Slf4j
public class GuahaoService {

  @Autowired
  GuahaoMapper guahaoMapper;

  public Guahao guahao(long userId, long departmentId, long doctorId) {
    Guahao guahao = new Guahao()
            .withUserId(userId)
            .withDepartmentId(departmentId)
            .withDoctorId(doctorId)
            .withCreateDate(new Date());
    guahaoMapper.insert(guahao);
    return guahao;
  }

  public long getOrderByGuahaoId(long guahaoId) {
    Guahao guahao = guahaoMapper.selectByPrimaryKey(guahaoId);

    GuahaoExample getExample = new GuahaoExample();
    getExample.createCriteria()
            .andCreateDateLessThan(guahao.getCreateDate())
            .andDepartmentIdEqualTo(guahao.getDepartmentId());

    long order = guahaoMapper.countByExample(getExample);

    return order;
  }
}
