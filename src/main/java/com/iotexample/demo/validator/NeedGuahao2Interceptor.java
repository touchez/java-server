package com.iotexample.demo.validator;

import com.alibaba.fastjson.JSON;
import com.iotexample.demo.model.Guahao;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.service.GuahaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-08-02 10:08
 */

@Slf4j
public class NeedGuahao2Interceptor implements HandlerInterceptor {
  @Autowired
  GuahaoService guahaoService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 如果不是映射到方法直接通过
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();

    // 判断接口是否需要挂号
    NeedGuahao2 methodAnnotation = method.getAnnotation(NeedGuahao2.class);
    //有@NeedGuahao2注解的需要检查
    if (methodAnnotation != null) {
      String userId = request.getParameter("userId");
      String departmentId = request.getParameter("departmentId");
      String doctorId = request.getParameter("doctorId");

      log.info("check guahao with userId : {} departmentId : {} doctorId : {}", userId, departmentId, doctorId);

      if (userId == null || departmentId == null || doctorId == null) {
        return false;
      }else {
        boolean isGuahao = guahaoService.checkGuahao(Long.parseLong(userId), Long.parseLong(departmentId), Long.parseLong(doctorId));

        if (!isGuahao) {
          response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), JSON.toJSONString(CodeMsg.SESSION_ERROR));
        }

        return isGuahao;
      }
    }

    return true;
  }
}
