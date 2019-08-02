package com.iotexample.demo.service;

import com.iotexample.demo.ResponseEntity.ResponseGuahaoWithOrder;
import com.iotexample.demo.dao.GuahaoMapper;
import com.iotexample.demo.exception.GlobalException;
import com.iotexample.demo.model.Guahao;
import com.iotexample.demo.model.GuahaoExample;
import com.iotexample.demo.mymapper.MyGuahaoMapper;
import com.iotexample.demo.mymapper.MyMedicalRecordMapper;
import com.iotexample.demo.result.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

  @Autowired
  MyGuahaoMapper myGuahaoMapper;

  public Guahao guahao(long userId, long departmentId, long doctorId) {
    String departmentName = departmentService.getDepartmentNameById(departmentId);
    Date now = new Date();
    Guahao guahao = new Guahao()
            .withUserId(userId)
            .withDepartmentId(departmentId)
            .withDepartmentName(departmentName)
            .withDoctorId(doctorId)
            .withCreateDate(now)
            .withEndDate(new Date(now.getTime() + 24 * 60 * 60 * 1000L))
            .withState(1);
//    log.info("before insert:{}", guahao);

    guahaoMapper.insertSelective(guahao);

//    log.info("after insert:{}", guahao);

    return guahao;
  }

  public long getOrderByGuahaoId(long guahaoId) {
    Guahao guahao = guahaoMapper.selectByPrimaryKey(guahaoId);

    GuahaoExample getExample = new GuahaoExample();
    getExample.createCriteria()
            .andCreateDateLessThan(guahao.getCreateDate())
            .andDepartmentIdEqualTo(guahao.getDepartmentId())
            .andStateEqualTo(1);

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

  /**
   * @Description: 根据userId返回用户的所有active的挂号消息并且按order排序
   * @Param: [userId]
   * @return: java.util.List<com.iotexample.demo.model.Guahao>
   * @Author: WenYuan
   * @Date: 2019-06-04
   */
  public List<ResponseGuahaoWithOrder> getActiveGuahaoOrderByTime(long userId) {
    GuahaoExample getExample = new GuahaoExample();
    //state为1说明是active的
    getExample.createCriteria()
            .andUserIdEqualTo(userId)
            .andStateEqualTo(1);

    List<Guahao> list = guahaoMapper.selectByExample(getExample);

    List<ResponseGuahaoWithOrder> list1 = new ArrayList<>();

    for (Guahao guahao : list) {
      ResponseGuahaoWithOrder e = new ResponseGuahaoWithOrder(guahao);
      e.setOrder(getOrderByGuahaoId(guahao.getGuahaoId()));
      list1.add(e);
    }

    //按照order(即前面剩余的人数)排序，升序
    list1.sort(new Comparator<ResponseGuahaoWithOrder>() {
      @Override
      public int compare(ResponseGuahaoWithOrder o1, ResponseGuahaoWithOrder o2) {
        int res = 0;
        if (o1.getOrder() > o2.getOrder()) {
          res = 1;
        } else if (o1.getOrder() < o2.getOrder()) {
          res = -1;
        }
        return res;
      }
    });

    return list1;
  }

  public ResponseGuahaoWithOrder getGuahaoDetail(long userId, long departmentId) {
    GuahaoExample guahaoExample = new GuahaoExample();
    guahaoExample.createCriteria()
            .andUserIdEqualTo(userId)
            .andDepartmentIdEqualTo(departmentId)
            .andStateEqualTo(1);

    List<Guahao> list = guahaoMapper.selectByExample(guahaoExample);

    if (list.size() != 1) {
      throw new GlobalException(CodeMsg.DB_ERROR);
    }

    Guahao guahao = list.get(0);

    ResponseGuahaoWithOrder e = new ResponseGuahaoWithOrder(guahao);
    e.setOrder(getOrderByGuahaoId(guahao.getGuahaoId()));

    return e;
  }

  public int deleteGuahaoByUserId(long userId) {
//    GuahaoExample guahaoExample = new GuahaoExample();
//    guahaoExample.createCriteria()
//            .andUserIdEqualTo(userId);

//    int res = guahaoMapper.deleteByExample(guahaoExample);
    int res = myGuahaoMapper.deleteGuahaoByUserId(userId);

    return res;
  }


  public boolean checkGuahao(long userId, long departmentId, long doctorId) {
    GuahaoExample guahaoExample = new GuahaoExample();
    guahaoExample.createCriteria()
            .andUserIdEqualTo(userId)
            .andDepartmentIdEqualTo(departmentId)
            .andDoctorIdEqualTo(doctorId)
            .andStateEqualTo(1);

    //找到了说明存在这个挂号，即挂过号了
    List<Guahao> guahaos = guahaoMapper.selectByExample(guahaoExample);

    return guahaos.size() > 0;
  }


  public Guahao setStateById(long guahaoId, int state) {

    Guahao guahao = guahaoMapper.selectByPrimaryKey(guahaoId);

    guahao.setState(state);

    guahaoMapper.updateByPrimaryKeySelective(guahao);

    return guahao;
  }
}
