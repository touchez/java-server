package com.iotexample.demo.RequestEntity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @program: iotdemo
 * @description: requet /examination/add 时用的entity
 * @author: WenYuan
 * @create: 2019-06-21 21:42
 */

@Getter
@Setter
public class RequestAddExaminationOrder {
  @NotNull(message = "userId不能为空")
  public Long userId;

  @NotNull(message = "medicalRecordId不能为空")
  public Long medicalRecordId;

  @NotNull(message = "examinationId不能为空")
  public Long examinationId;

  @NotNull(message = "examinationType不能为空")
  public String examinationType;
}
