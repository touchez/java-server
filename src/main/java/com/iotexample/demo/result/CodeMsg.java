package com.iotexample.demo.result;

public class CodeMsg {
  private int code;
  private String msg;

  /**通用异常*/
  public static CodeMsg SUCCESS = new CodeMsg(0, "success");
  public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
  public static CodeMsg DB_ERROR = new CodeMsg(500200, "数据库异常");
  /**没获取到挂号的session*/
  public static CodeMsg SESSION_ERROR = new CodeMsg(500300, "请先挂号");
  /**去了错误的检查地点*/
  public static CodeMsg CHECK_ERROR = new CodeMsg(500400, "错误的检查地点");
  /**重复挂号*/
  public static CodeMsg DUPLICATE_ERROR = new CodeMsg(500500, "不能重复挂号");


  private CodeMsg(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public CodeMsg fillArgs(Object... args) {
    int code = this.code;
    String message = String.format(this.msg, args);
    return new CodeMsg(code, message);
  }

  public int getCode() {
    return code;
  }
  public String getMsg() {
    return msg;
  }
}
