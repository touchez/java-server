package com.iotexample.demo.service;

import com.iotexample.demo.RequestEntity.RequestNew;
import com.iotexample.demo.dao.MedicalrecordMapper;
import com.iotexample.demo.model.Medicalrecord;
import com.iotexample.demo.model.MedicalrecordExample;
import com.iotexample.demo.mymapper.MyMedicalRecordMapper;
import com.iotexample.demo.vo.SimpleMedicalRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Date;
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

  @Autowired
  DepartmentService departmentService;

  @Autowired
  MyMedicalRecordMapper myMedicalRecordMapper;

  public List<Medicalrecord> getMedicalRecordByUserId(long userId) {
    MedicalrecordExample medicalrecordExample = new MedicalrecordExample();
    medicalrecordExample.createCriteria()
            .andUserIdEqualTo(userId);

    List<Medicalrecord> list = medicalrecordMapper.selectByExample(medicalrecordExample);
    //list.forEach(e -> log.info("select by example {}", e));
    return list;
  }

  public Medicalrecord getMedicalRecordById(long medicalRecordId) {
    Medicalrecord medicalrecord = medicalrecordMapper.selectByPrimaryKey(medicalRecordId);

    return medicalrecord;
  }

  public List<SimpleMedicalRecord> getSimpleMedicalRecordByUserId(Long userId) {
    List<SimpleMedicalRecord> list = new ArrayList<>();

    MedicalrecordExample medicalrecordExample = new MedicalrecordExample();
    medicalrecordExample.createCriteria()
            .andUserIdEqualTo(userId);

    List<Medicalrecord> list2 = medicalrecordMapper.selectByExample(medicalrecordExample);
    for (Medicalrecord medicalrecord : list2) {
      String departmentName = departmentService.getDepartmentNameById(medicalrecord.getDepartmentId());

      String hospitalName = departmentService.getHospitalNameByDepartmentId(medicalrecord.getDepartmentId());

      SimpleMedicalRecord simpleMedicalRecord =
              new SimpleMedicalRecord(medicalrecord.getMedicalrecordId(), medicalrecord.getGeneral(), departmentName, hospitalName, medicalrecord.getCreateDate());

      list.add(simpleMedicalRecord);
    }

    return list;
  }

  //返回主键值
  public long updateMedicalRecord(Medicalrecord medicalrecord) {

    long medicalRecordId = 0;

    if (medicalrecord.getMedicalrecordId() == null) {
      //第一次获得病历，没有设置id
      if (medicalrecord.getCreateDate() == null) {
        medicalrecord.setCreateDate(new Date());
      }

      int res = medicalrecordMapper.insertSelective(medicalrecord);
    } else {
      //有id则一定在数据库中，故更新
      int res = medicalrecordMapper.updateByPrimaryKeySelective(medicalrecord);
    }

    medicalRecordId = medicalrecord.getMedicalrecordId();

    return medicalRecordId;
  }

  public Medicalrecord newOneMediacalRecord(RequestNew requestNew) {
    Medicalrecord medicalrecord = new Medicalrecord()
            .withUserId(requestNew.getUserId())
            .withDepartmentId(requestNew.getDepartmentId())
            .withDoctorId(requestNew.getDoctorId())
            .withCreateDate(new Date());

    int res = medicalrecordMapper.insertSelective(medicalrecord);

    return medicalrecord;
  }

  public long getLatestMedicalRecordId() {
    long medicalRecordId = myMedicalRecordMapper.getLatestMedicalRecordId();
    return medicalRecordId;
  }
}
