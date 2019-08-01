package com.iotexample.demo.mongorepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @program: iotdemo
 * @description: 用来存导游机类
 * @author: WenYuan
 * @create: 2019-08-01 20:20
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideMachine {
  @Id
  private String guideMachineId;
  private Date createDate;
  private String poster;
  private String name;
  private String author;
  private String src;
  private String title;
  private String content;
}
