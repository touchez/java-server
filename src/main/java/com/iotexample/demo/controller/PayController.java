package com.iotexample.demo.controller;

import com.alibaba.fastjson.JSON;
import com.iotexample.demo.RequestEntity.RequestPayExamination;
import com.iotexample.demo.RequestEntity.RequestPayTreatment;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pay")
@Slf4j
public class PayController {
  @Autowired
  PayService payService;

  /**
   * @Description: 根据userId和examinationOrderId来支付检查费用
   * @Param: [requestPayExamination]
   * @return: com.iotexample.demo.result.Result<java.lang.String>
   * @Author: WenYuan
   * @Date: 2019-06-04
   */
  @PostMapping("/examinationOrder")
  @CrossOrigin
  public Result<String> payExamination(@Valid @RequestBody RequestPayExamination requestPayExamination) {
    log.info("request body:{}", JSON.toJSON(requestPayExamination));
    long userId = requestPayExamination.getUserId();
    long examinationOrderId = requestPayExamination.getExaminationorderId();
    int res = payService.payExaminationOrderByUserIdAndId(userId, examinationOrderId);
    if (res > 0) {
      return Result.success("pay examination success");
    } else if (res == -2) {
      return Result.error(CodeMsg.BALANCE_ERROR);
    } else if (res == -1) {
      return Result.error(CodeMsg.REPEAT_PAY_ERROR);
    } else {
      return Result.error(CodeMsg.SERVER_ERROR);
    }
  }

  /**
   * @Description: 根据userId和treatmentId来支付治疗费用
   * @Param: [requestPayTreatment]
   * @return: com.iotexample.demo.result.Result<java.lang.String>
   * @Author: WenYuan
   * @Date: 2019-06-04
   */
  @PostMapping("/treatment")
  @CrossOrigin
  public Result<String> payTreatment(@Valid @RequestBody RequestPayTreatment requestPayTreatment) {
    log.info("request body:{}", JSON.toJSON(requestPayTreatment));
    long userId = requestPayTreatment.getUserId();
    long treatmentId = requestPayTreatment.getTreatmentId();
    int res = payService.payTreatmentByUserIdAndId(userId, treatmentId);
    if (res > 0) {
      return Result.success("pay treatment success");
    } else if (res == -2) {
      return Result.error(CodeMsg.BALANCE_ERROR);
    } else if (res == -1) {
      return Result.error(CodeMsg.REPEAT_PAY_ERROR);
    } else {
      return Result.error(CodeMsg.SERVER_ERROR);
    }
  }

}
