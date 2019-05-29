package com.iotexample.demo.aspect;

import com.alibaba.fastjson.JSON;
import com.iotexample.demo.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: iotdemo
 * @description: 请求统一响应
 * @author: WenYuan
 * @create: 2019-05-27 19:57
 **/

@Aspect
@Component
@Slf4j
public class RestControllerAspect {

  @Pointcut("execution(public * com.iotexample.demo.controller.*.*(..))")
  public void log() {
  }

  @Before("log()")
  public void doBefor(JoinPoint joinPoint) {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    Map<String, String> params = new HashMap<>();
    params.put("url", request.getRequestURL().toString());
    params.put("method", request.getMethod());
    params.put("ip", IPUtil.getIpAddr(request));
    params.put("className", joinPoint.getSignature().getDeclaringTypeName());
    params.put("classMethod", joinPoint.getSignature().getName());
    //params.put("args", JSON.toJSONString(joinPoint.getArgs()));

    log.info("REQUEST: {}", JSON.toJSONString(params));
  }

  @After("log()")
  public void doAfter() {
    log.info("doAfter");
  }

}
