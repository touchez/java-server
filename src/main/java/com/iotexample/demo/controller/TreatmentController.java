package com.iotexample.demo.controller;

import com.iotexample.demo.model.Treatment;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentController {
  @Autowired
  TreatmentService treatmentService;

  @GetMapping("/{userId}")
  public Result<List<Treatment>> getTreatmentByUserId(@PathVariable("userId")long userId, @RequestParam("payState")int payState) {
    List<Treatment> list = treatmentService.getTreatmentsByUserIdAndPayState(userId, payState);
    return Result.success(list);
  }
}
