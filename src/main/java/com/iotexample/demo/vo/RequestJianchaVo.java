package com.iotexample.demo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: iotdemo
 * @description: 检查接口接收的参数
 * @author: WenYuan
 * @create: 2019-06-02 19:25
 **/

@Data
@Getter
@Setter
public class RequestJianchaVo {
  private long jianchaId;
  private long userId;
}
