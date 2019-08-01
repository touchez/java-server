package com.iotexample.demo.mongorepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: iotdemo
 * @description: 存储一些药品信息
 * @author: WenYuan
 * @create: 2019-08-01 16:09
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {
  @Id
  private String medicineId;
  private String medicineName;
  private String medicineQuality;
  private String medicineUsage;
  private String validTime;
}
