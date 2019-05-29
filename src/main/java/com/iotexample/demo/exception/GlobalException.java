package com.iotexample.demo.exception;

import com.iotexample.demo.result.CodeMsg;

/**
 * @program: iotdemo
 * @description: 全局异常
 * @author: WenYuan
 * @create: 2019-05-28 09:23
 **/

public class GlobalException extends RuntimeException {
  private CodeMsg codeMsg;

  public GlobalException(CodeMsg codeMsg) {
    super(codeMsg.toString());
    this.codeMsg = codeMsg;
  }

  public CodeMsg getCodeMsg() {
    return codeMsg;
  }
}
