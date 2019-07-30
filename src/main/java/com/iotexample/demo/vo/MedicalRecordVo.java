package com.iotexample.demo.vo;

import com.iotexample.demo.RequestEntity.RequestMedicalRecord;
import com.iotexample.demo.model.Examinationorder;
import com.iotexample.demo.model.Medicalrecord;
import com.iotexample.demo.model.TreatmentDrugOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: iotdemo
 * @description: web页面使用的整个病史的实体类
 * @author: WenYuan
 * @create: 2019-06-22 16:35
 */

@Getter
@Setter
@AllArgsConstructor
public class MedicalRecordVo {
  private Medicalrecord medicalrecord;
  private List<RequestMedicalRecord> requestMedicalRecords;
  private List<TreatmentDrugOrder> treatmentDrugOrders;
  private List<SimpleMedicalRecord> simpleMedicalRecords;


}

