package com.iotexample.demo.vo;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @program: iotdemo
 * @description: 接收就诊页面的消息用
 * @author: WenYuan
 * @create: 2019-05-23 17:48
 **/

@Generated
@Getter
@Setter
public class JiuzhenVo {
  private Long jiuzhenId;
  private Long doctorId;
  private String doctorName;
  private Long guahaoId;
  private Long userId;
  private Date createDate;
  private String jiuzhenContent;
  private Long[] jianchaIds;
}
