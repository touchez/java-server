package com.iotexample.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @program: iotdemo
 * @description: 简单显示过往病例的类
 * @author: WenYuan
 * @create: 2019-06-22 16:55
 */
@Getter
@Setter
@AllArgsConstructor
public class SimpleMedicalRecord {
  Long medicalRecordId;
  String generalName;
  String departmentName;
  String hospitalName;
  Date createDate;
}
