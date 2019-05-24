package com.iotexample.demo.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @program: iotdemo
 * @description: my config
 * @author: WenYuan
 * @create: 2019-05-22 23:26
 **/

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    //自定义配置...
    //FastJsonConfig config = new FastJsonConfig();
    //config.set ...
    //converter.setFastJsonConfig(config);
    converters.add(0, converter);
  }
}
