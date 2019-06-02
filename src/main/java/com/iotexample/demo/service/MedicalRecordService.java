package com.iotexample.demo.service;

import com.iotexample.demo.dao.MedicalrecordMapper;
import com.iotexample.demo.model.Medicalrecord;
import com.iotexample.demo.model.MedicalrecordExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iotdemo
 * @description: 病历的Service
 * @author: WenYuan
 * @create: 2019-06-02 21:23
 **/

@Service
@Slf4j
public class MedicalRecordService {
  @Autowired
  MedicalrecordMapper medicalrecordMapper;

  public List<Medicalrecord> getMedicalRecordByUserId(long userId) {
    MedicalrecordExample medicalrecordExample = new MedicalrecordExample();
    medicalrecordExample.createCriteria()
            .andUserIdEqualTo(userId);

    List<Medicalrecord> list = medicalrecordMapper.selectByExample(medicalrecordExample);
    list.forEach(e -> log.info("select by example {}", e));
    return list;
  }

  public Medicalrecord getMedicalRecordById(long medicalRecordId) {
    Medicalrecord medicalrecord = medicalrecordMapper.selectByPrimaryKey(medicalRecordId);

    return medicalrecord;
  }
}
