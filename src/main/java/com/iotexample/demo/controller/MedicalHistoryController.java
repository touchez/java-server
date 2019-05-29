package com.iotexample.demo.controller;

import com.iotexample.demo.mongorepository.MedicalHistory;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.MedicalHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: iotdemo
 * @description: 病史的controller
 * @author: WenYuan
 * @create: 2019-05-28 17:17
 **/
@RequestMapping("/medicalHistory")
@RestController
@Slf4j
public class MedicalHistoryController {

  @Autowired
  MedicalHistoryService medicalHistoryService;

  @GetMapping("/{user}")
  public Result<List<MedicalHistory>> getMedicalHistory(@PathVariable("user") String user) {
    if (user == null) {
      return Result.error(CodeMsg.SERVER_ERROR);
    }

    List<MedicalHistory> list = medicalHistoryService.findAllByUser(user);

    return Result.success(list);
  }

  @PostMapping
  public Result<String> addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
    log.info("get data {}", medicalHistory);

    String medicalHistoryId = medicalHistoryService.add(medicalHistory);
    if (medicalHistory == null) {
      return Result.error(CodeMsg.SERVER_ERROR);
    }

    return Result.success(medicalHistoryId);
  }
}
