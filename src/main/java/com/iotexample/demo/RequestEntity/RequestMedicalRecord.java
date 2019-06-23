package com.iotexample.demo.RequestEntity;

import com.iotexample.demo.ResponseEntity.ResponseSimpleExaminationType;
import com.iotexample.demo.model.Medicalrecord;
import com.iotexample.demo.model.TreatmentDrugOrder;
import com.iotexample.demo.vo.SimpleMedicalRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RequestMedicalRecord {
  private Medicalrecord medicalrecord;
  private List<Long> examinationTypesId;
  private List<TreatmentDrugOrder> treatmentDrugOrders;
}
