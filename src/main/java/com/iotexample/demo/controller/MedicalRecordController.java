package com.iotexample.demo.controller;

import com.iotexample.demo.ResponseEntity.ResponseMedicalRecord;
import com.iotexample.demo.ResponseEntity.ResponseMedicalRecord2;
import com.iotexample.demo.model.Examinationorder;
import com.iotexample.demo.model.Medicalrecord;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.DepartmentService;
import com.iotexample.demo.service.ExaminationOrderService;
import com.iotexample.demo.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 病历的controller
 * @author: WenYuan
 * @create: 2019-06-02 21:26
 **/

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {
  @Autowired
  MedicalRecordService medicalRecordService;

  @Autowired
  DepartmentService departmentService;

  @Autowired
  ExaminationOrderService examinationOrderService;

  /** 
  * @Description: 根据userId获取用户的所以病历
  * @Param: [userId] 
  * @return: com.iotexample.demo.result.Result<java.util.List<com.iotexample.demo.ResponseEntity.ResponseMedicalRecord>> 
  * @Author: WenYuan
  * @Date: 2019/6/2 
  */
  @GetMapping("/{userId}")
  public Result<List<ResponseMedicalRecord>> getAllMedicalRecord(@PathVariable("userId")long userId) {
    List<Medicalrecord> list = medicalRecordService.getMedicalRecordByUserId(userId);
    List<ResponseMedicalRecord> resList = new ArrayList<>();
    for (Medicalrecord mr : list) {
      String addr = departmentService.getAddrByDepartmentId(mr.getDepartmentId());
      resList.add(new ResponseMedicalRecord(mr, addr));
    }
    return Result.success(resList);
  }
  /** 
  * @Description: 根据medicalRecorderId返回病历的所有信息，包括检查的信息
  * @Param: [medicalRecordId] 
  * @return: com.iotexample.demo.result.Result<com.iotexample.demo.ResponseEntity.ResponseMedicalRecord2> 
  * @Author: WenYuan
  * @Date: 2019/6/2 
  */
  @GetMapping
  public Result<ResponseMedicalRecord2> getAllMedicalRecord2(@RequestParam("medicalRecordId") long medicalRecordId) {
    Medicalrecord medicalrecord = medicalRecordService.getMedicalRecordById(medicalRecordId);

    List<Examinationorder> list = examinationOrderService.getAllExaminationOrderByMedicalRecordId(medicalRecordId);

    return Result.success(new ResponseMedicalRecord2(medicalrecord, list));
  }
}
