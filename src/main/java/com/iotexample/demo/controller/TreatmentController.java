package com.iotexample.demo.controller;

import com.iotexample.demo.model.Treatment;
import com.iotexample.demo.model.TreatmentDrugOrder;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.TreatmentDrugOrderService;
import com.iotexample.demo.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentController {
  @Autowired
  TreatmentService treatmentService;

  @Autowired
  TreatmentDrugOrderService treatmentDrugOrderService;

  @GetMapping("/{userId}")
  public Result<List<Treatment>> getTreatmentByUserId(@PathVariable("userId") long userId, @RequestParam("payState") int payState) {
    List<Treatment> list = treatmentService.getTreatmentsByUserIdAndPayState(userId, payState);
    return Result.success(list);
  }

  @GetMapping("/get")
  public Result<List<TreatmentDrugOrder>> getByMedicalRecordId(@RequestParam("medicalRecordId") long medicalRecordId) {
    List<TreatmentDrugOrder> list2 = treatmentDrugOrderService.getAllTreatmentDrugOrderByMedicalRecordId(medicalRecordId);

    return Result.success(list2);
  }
}
