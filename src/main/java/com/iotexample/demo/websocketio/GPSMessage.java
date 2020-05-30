package com.iotexample.demo.websocketio;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GPSMessage {
  public String lat;
  public String lon;
}
