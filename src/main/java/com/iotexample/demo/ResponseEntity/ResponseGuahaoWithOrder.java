package com.iotexample.demo.ResponseEntity;

import com.iotexample.demo.model.Guahao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGuahaoWithOrder {
  private Guahao guahao;
  private long order;

  public ResponseGuahaoWithOrder(Guahao guahao) {
    this.guahao = guahao;
  }
}
