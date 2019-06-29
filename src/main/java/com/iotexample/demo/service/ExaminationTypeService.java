package com.iotexample.demo.service;


import com.iotexample.demo.ResponseEntity.ResponseSimpleExaminationType;
import com.iotexample.demo.ResponseEntity.ResponseSimpleExaminationTypeWithAddr;
import com.iotexample.demo.dao.ExaminationTypeMapper;
import com.iotexample.demo.exception.GlobalException;
import com.iotexample.demo.model.*;
import com.iotexample.demo.mymapper.MyExaminationOrderMapper;
import com.iotexample.demo.result.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.*;

@Service
@Slf4j
public class ExaminationTypeService {
  @Autowired
  ExaminationTypeMapper examinationTypeMapper;

  @Autowired
  MedicalRecordService medicalRecordService;

  @Autowired
  ExaminationOrderService examinationOrderService;

  @Autowired
  MyExaminationOrderMapper myExaminationOrderMapper;


  public List<ResponseSimpleExaminationType> getAllExaminationType() {
    ExaminationTypeExample examinationTypeExample = new ExaminationTypeExample();
    examinationTypeExample.createCriteria();

    List<ExaminationType> list = examinationTypeMapper.selectByExample(examinationTypeExample);

    List<ResponseSimpleExaminationType> resList = new ArrayList<>();

    for (ExaminationType e : list) {
      resList.add(new ResponseSimpleExaminationType(e));
    }

    return resList;
  }


  public List<ResponseSimpleExaminationType> getAllExaminationTypeByMedicalRecordId(long medicalRecordId) {
    ExaminationorderExample examinationorderExample = new ExaminationorderExample();
    examinationorderExample.createCriteria()
            .andMedicalrecordIdEqualTo(medicalRecordId);

    List<Examinationorder> list = examinationOrderService.getAllExaminationOrderByMedicalRecordId(medicalRecordId);

    List<ResponseSimpleExaminationType> resList = new ArrayList<>();

    for (Examinationorder e : list) {
      Long examinationTypeId = e.getExaminationTypeId();
      ExaminationType examinationType = examinationTypeMapper.selectByPrimaryKey(examinationTypeId);
      resList.add(new ResponseSimpleExaminationType(examinationType));
    }

    return resList;
  }

  public List<ExaminationType> getExaminationTypesByIds(List<Long> examinationTypesId) {
    if (examinationTypesId == null || examinationTypesId.size() <=0) {
      throw new GlobalException(CodeMsg.SERVER_ERROR);
    }

    List<ExaminationType> list = new ArrayList<>();

    for (Long l : examinationTypesId) {
      ExaminationType e = examinationTypeMapper.selectByPrimaryKey(l);
      list.add(e);
    }

    return list;
  }

  public List<ResponseSimpleExaminationTypeWithAddr> getAllExaminationTypeByUserIdAndDate(long userId, Date date) {

    List<Examinationorder> list = myExaminationOrderMapper.getAllExaminationorderByUserIdAndDate(userId, date);

    List<ResponseSimpleExaminationTypeWithAddr> resList = new ArrayList<>();

    for (Examinationorder e : list) {
      Long examinationTypeId = e.getExaminationTypeId();
      ExaminationType examinationType = examinationTypeMapper.selectByPrimaryKey(examinationTypeId);
      log.info("this time is:{}", e.getTime());
      resList.add(new ResponseSimpleExaminationTypeWithAddr(examinationType, e.getTime()));
    }

    return resList;
  }
}
