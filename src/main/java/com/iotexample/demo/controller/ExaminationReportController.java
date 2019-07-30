package com.iotexample.demo.controller;

import com.iotexample.demo.model.ExaminationReport;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.ExaminationReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-07-30 22:35
 */

@RestController
@RequestMapping("/examination_report")
@CrossOrigin
@Slf4j
public class ExaminationReportController {

  @Autowired
  ExaminationReportService examinationReportService;

  @PostMapping("/add")
  public Result<ExaminationReport> add(@RequestBody ExaminationReport examinationReport) {
    ExaminationReport examinationReport1 = examinationReportService.add(examinationReport);

    return Result.success(examinationReport1);
  }

  @GetMapping("/get")
  public Result<ExaminationReport> get(@RequestParam("Id") long id) {
    ExaminationReport examinationReport = examinationReportService.getById(id);

    if (examinationReport == null) {
      return Result.error(CodeMsg.INVALID_PARAM_ERROR);
    }

    return Result.success(examinationReport);
  }
}
