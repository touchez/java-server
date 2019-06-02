package com.iotexample.demo.service;

import com.iotexample.demo.dao.ExaminationorderMapper;
import com.iotexample.demo.model.Examinationorder;
import com.iotexample.demo.model.ExaminationorderExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
