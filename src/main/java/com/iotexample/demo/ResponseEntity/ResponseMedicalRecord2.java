package com.iotexample.demo.ResponseEntity;

import com.iotexample.demo.model.Examinationorder;
import com.iotexample.demo.model.Medicalrecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 存放完整的病历信息和检查id及其类别
 * @author: WenYuan
 * @create: 2019-06-02 21:05
 **/
@Getter
@Setter
public class ResponseMedicalRecord2 {
  private Medicalrecord medicalrecord;
  private List<ExamIdType> examinationOrder;
  public ResponseMedicalRecord2 (Medicalrecord medicalrecord, List<Examinationorder> examinationorders) {
    this.medicalrecord = medicalrecord;
    examinationOrder = new ArrayList<>();
    for (Examinationorder e : examinationorders) {
      examinationOrder.add(new ExamIdType(e.getExaminationorderId(), e.getExaminationType()));
    }
  }
}
@Getter
@Setter
@AllArgsConstructor
class ExamIdType {
  private long examinationOrderId;
  private String examinationType;
}