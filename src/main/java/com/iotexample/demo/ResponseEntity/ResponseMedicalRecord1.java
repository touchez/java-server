package com.iotexample.demo.ResponseEntity;

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
public class ResponseMedicalRecord1 {
  private Medicalrecord medicalrecord;
  private List<ResponseSimpleExaminationType> responseSimpleExaminationTypes;
  private List<TreatmentDrugOrder> treatmentDrugOrders;
  private List<SimpleMedicalRecord> simpleMedicalRecords;
}
