package com.iotexample.demo;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Value("${socketIO.host}")
  private String host;

  @Value("${socketIO.port}")
  private int port;

  /**
   * 注册socketIO的bean
   * @return
   */

  @Bean
  public SocketIOServer socketIOServer() {
    Configuration config = new Configuration();
    config.setHostname(host);
    config.setPort(port);

    SocketConfig socketConfig = new SocketConfig();
    socketConfig.setReuseAddress(true);
    config.setSocketConfig(socketConfig);

    config.setKeyStorePassword("123456");
    InputStream stream = getClass().getClassLoader().getResourceAsStream("./touchez.jks");
    config.setKeyStore(stream);

    final SocketIOServer server = new SocketIOServer(config);
    return server;
  }

  /**
   * tomcat启动时候，扫码socket服务器并注册
   * @param socketIOServer
   * @return
   */
  @Bean
  public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer) {
    return new SpringAnnotationScanner(socketIOServer);
  }

}
