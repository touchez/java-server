package com.iotexample.demo.exception;

import com.iotexample.demo.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: iotdemo
 * @description: 全局异常处理
 * @author: WenYuan
 * @create: 2019-05-28 09:24
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler extends BaseAggregationLayerGlobalExceptionHandler {

  /**
   * @Description: 处理运行时异常时返回的http状态为500之类的，同时再调用处理异常的函数
   * @Param: [e, request]
   * @return: com.imooc.miaosha.result.Result<java.lang.String>
   * @Author: WenYuan
   * @Date: 2019/5/28
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(RuntimeException.class)
  @Override
  public Result<String> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
    return super.handleRuntimeException(e, request);
  }
}
