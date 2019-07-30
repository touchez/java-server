package com.iotexample.demo.ResponseEntity;

import com.iotexample.demo.model.ExaminationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-06-29 16:30
 */

@ToString
@Getter
@Setter
@Data
public class ResponseSimpleExaminationTypeWithAddr implements Serializable {
  private Long examinationTypeId;
  private String generalString;
  private String addr;
  private Date time;

  public ResponseSimpleExaminationTypeWithAddr(ExaminationType examinationType, Date date) {
    this.examinationTypeId = examinationType.getExaminationTypeId();
    this.generalString = examinationType.getExaminationTypeName() + examinationType.getExaminationTypeDetail();
    this.addr = examinationType.getExaminationAddr();
    this.time = date;
  }
}
