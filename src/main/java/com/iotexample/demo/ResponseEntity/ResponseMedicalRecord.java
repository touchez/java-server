package com.iotexample.demo.ResponseEntity;

import com.iotexample.demo.model.Medicalrecord;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @program: iotdemo
 * @description: 用来响应的病历实体
 * @author: WenYuan
 * @create: 2019-06-02 20:49
 **/

@Getter
@Setter
@Slf4j
public class ResponseMedicalRecord {
  private Date date;
  private String addr;
  private String hospitalName;
  private String generalName;
  private long medicalRecordId;

  public ResponseMedicalRecord(Medicalrecord medicalrecord, String addr, String hospitalName) {
    this.date = medicalrecord.getCreateDate();
    this.addr = addr;
    this.hospitalName = hospitalName;
    this.generalName = medicalrecord.getGeneral();
    log.info("general is:{}",generalName);
    this.medicalRecordId = medicalrecord.getMedicalrecordId();
  }
}
