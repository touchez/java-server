package com.iotexample.demo.RequestEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-06-29 19:56
 */

@Getter
@Setter
@AllArgsConstructor
public class RequestNew {
  private Long userId;
  private Long departmentId;
  private Long doctorId;

}
