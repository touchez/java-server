package com.iotexample.demo.controller;


import com.iotexample.demo.ResponseEntity.ResponseSimpleExaminationType;
import com.iotexample.demo.model.ExaminationType;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.ExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/examtype")
public class ExaminationTypeController {

  @Autowired
  ExaminationTypeService examinationTypeService;

  @GetMapping("/all")
  public Result<List<ResponseSimpleExaminationType>> getAllExaminationType() {
    List<ResponseSimpleExaminationType> list = examinationTypeService.getAllExaminationType();

    return Result.success(list);
  }
}
