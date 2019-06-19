package com.iotexample.demo.RequestEntity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RequestPayTreatment {
  @NotNull(message = "userId不能为空")
  private Long userId;

  @NotNull(message = "treatmentId不能为空")
  private Long treatmentId;
}
