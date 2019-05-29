package com.iotexample.demo.mongorepository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @program: iotdemo
 * @description: 病史类，用mongodb存储
 * @author: WenYuan
 * @create: 2019-05-28 17:11
 **/

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalHistory {
  @Id
  private String id;
  private String user;
  private String sick;
  private Date date;
  private String hospital;

}
