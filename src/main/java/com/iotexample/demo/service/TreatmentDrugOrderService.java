package com.iotexample.demo.service;

import com.iotexample.demo.dao.TreatmentDrugOrderMapper;
import com.iotexample.demo.dao.TreatmentMapper;
import com.iotexample.demo.model.Treatment;
import com.iotexample.demo.model.TreatmentDrugOrder;
import com.iotexample.demo.model.TreatmentDrugOrderExample;
import com.iotexample.demo.model.TreatmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 治疗药品流水的service
 * @author: WenYuan
 * @create: 2019-06-22 16:46
 */

@Service
public class TreatmentDrugOrderService {

  @Autowired
  TreatmentDrugOrderMapper treatmentDrugOrderMapper;

  @Autowired
  TreatmentMapper treatmentMapper;

  public List<TreatmentDrugOrder> getAllTreatmentDrugOrderByMedicalRecordId(long medicalRecordId) {

    List<Long> treatmentIds = getAllTreatmentIdByMedicalRecordId(medicalRecordId);

    List<TreatmentDrugOrder> resList = new ArrayList<>();

    for (Long id: treatmentIds) {
      TreatmentDrugOrderExample treatmentDrugOrderExample = new TreatmentDrugOrderExample();
      treatmentDrugOrderExample.createCriteria()
              .andTreatmentIdEqualTo(id);

      List<TreatmentDrugOrder> list = treatmentDrugOrderMapper.selectByExample(treatmentDrugOrderExample);

      resList.addAll(list);
    }

    return resList;
  }

  public List<Long> getAllTreatmentIdByMedicalRecordId(long medicalRecordId) {
    TreatmentExample treatmentExample = new TreatmentExample();
    treatmentExample.createCriteria()
            .andMedicalrecordIdEqualTo(medicalRecordId);

    List<Treatment> list = treatmentMapper.selectByExample(treatmentExample);

    List<Long> resList = new ArrayList<>();

    for (Treatment treatment : list) {
      resList.add(treatment.getTreatmentId());
    }

    return resList;
  }

  public int updateTreatmentDrugOrder(List<TreatmentDrugOrder> treatmentDrugOrders, long treatmentId) {
    for (TreatmentDrugOrder t : treatmentDrugOrders) {

      if (t.getCreateDate() == null) {
        t.setCreateDate(new Date());
      }

      if (t.getTreatmentId() == null) {
        t.setTreatmentId(treatmentId);
        int res = treatmentDrugOrderMapper.insertSelective(t);
      }

    }

    return 0;

  }
}
