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
  DepartmentService departmentService;

  @Autowired
  GuahaoMapper guahaoMapper;

  public Guahao guahao(long userId, long departmentId, long doctorId) {
    String departmentName = departmentService.getDepartmentNameById(departmentId);
    Guahao guahao = new Guahao()
            .withUserId(userId)
            .withDepartmentId(departmentId)
            .withDepartmentName(departmentName)
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

  /**
  * @Description: 根据userId查询所有挂号记录
  * @Param: [userId]
  * @return: java.util.List<com.iotexample.demo.model.Guahao>
  * @Author: WenYuan
  * @Date: 2019/6/2
  */
  public List<Guahao> getGuahao(long userId) {
    GuahaoExample getExample = new GuahaoExample();
    getExample.createCriteria()
            .andUserIdEqualTo(userId)
            .andEndDateIsNull();//endDatew为null说明还未结束

    List<Guahao> list = guahaoMapper.selectByExample(getExample);
    return list;
  }

  public int updateEndDate(long guahaoId) {
    Guahao guahao = guahaoMapper.selectByPrimaryKey(guahaoId);
    guahao.setEndDate(new Date());
    int res = guahaoMapper.updateByPrimaryKeySelective(guahao);
    return res;
  }
}
