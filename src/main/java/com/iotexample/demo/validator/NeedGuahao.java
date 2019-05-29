package com.iotexample.demo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: iotdemo
 * @description: 在需要挂号的接口上使用此注解
 * @author: WenYuan
 * @create: 2019-05-28 09:47
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedGuahao {
}
