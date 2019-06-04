package com.iotexample.demo.service;

import com.iotexample.demo.dao.TreatmentMapper;
import com.iotexample.demo.model.Treatment;
import com.iotexample.demo.model.TreatmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
  @Autowired
  TreatmentMapper treatmentMapper;


  public List<Treatment> getTreatmentsByUserIdAndPayState(long userId, int payState) {
    TreatmentExample treatmentExample = new TreatmentExample();
    treatmentExample.createCriteria()
            .andUserIdEqualTo(userId)
            .andPayStateEqualTo(payState);

    List<Treatment> list = treatmentMapper.selectByExample(treatmentExample);
    return list;
  }
}
