package com.iotexample.demo.validator;

import com.alibaba.fastjson.JSON;
import com.iotexample.demo.model.Guahao;
import com.iotexample.demo.model.User;
import com.iotexample.demo.myredis.UserKey;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @program: iotdemo
 * @description: 需要挂号注解使用的拦截器
 * @author: WenYuan
 * @create: 2019-05-28 09:52
 **/

@Slf4j
public class NeedGuahaoInterceptor implements HandlerInterceptor {

  @Autowired
  UserService userService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 如果不是映射到方法直接通过
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();

    // 判断接口是否需要挂号
    NeedGuahao methodAnnotation = method.getAnnotation(NeedGuahao.class);
    //有@NeedGuahao注解的需要认证
    if (methodAnnotation != null) {
      //获取cookie
      String token = getCookieValue(request, UserService.COOKIE_NAME_TOKEN);
      long userId = userService.getByToken(token);
      if (userId == -1) {
        log.info("need guahao");
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), JSON.toJSONString(CodeMsg.SESSION_ERROR));
        //response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return false;
      }
    }

    return true;
  }

  private String getCookieValue(HttpServletRequest request, String cookieName) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      return null;
    }
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(cookieName)) {
        return cookie.getValue();
      }
    }
    return null;
  }
}
