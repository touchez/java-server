package com.iotexample.demo.myredis;

/**
 * @program: iotdemo
 * @description: 包装类，用来解决闭包无法对闭包外的变量进行修改的问题
 * @author: WenYuan
 * @create: 2019-07-19 10:42
 */

public class Holder<T> {

  private T value;

  public Holder() {

  }

  public Holder(T value) {
    this.value = value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }


}
