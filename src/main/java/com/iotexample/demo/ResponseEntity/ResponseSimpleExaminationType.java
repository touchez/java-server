package com.iotexample.demo.ResponseEntity;

import com.iotexample.demo.model.ExaminationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class ResponseSimpleExaminationType {
  private Long examinationTypeId;
  private String generalString;

  public ResponseSimpleExaminationType(ExaminationType examinationType) {
    this.examinationTypeId = examinationType.getExaminationTypeId();
    this.generalString = examinationType.getExaminationTypeName() + examinationType.getExaminationTypeDetail();
  }
}
