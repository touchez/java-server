package com.iotexample.demo.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-06-29 20:04
 */

@Getter
@Setter
@AllArgsConstructor
public class ResponseNew {
  private Long medicalRecordId;
  private String doctorName;
  private String departmentName;
}
