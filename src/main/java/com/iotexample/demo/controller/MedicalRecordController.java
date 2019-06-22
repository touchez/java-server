package com.iotexample.demo.controller;

import com.iotexample.demo.ResponseEntity.ResponseMedicalRecord;
import com.iotexample.demo.ResponseEntity.ResponseMedicalRecord2;
import com.iotexample.demo.model.Examinationorder;
import com.iotexample.demo.model.Medicalrecord;
import com.iotexample.demo.model.TreatmentDrugOrder;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.DepartmentService;
import com.iotexample.demo.service.ExaminationOrderService;
import com.iotexample.demo.service.MedicalRecordService;
import com.iotexample.demo.service.TreatmentDrugOrderService;
import com.iotexample.demo.vo.MedicalRecordVo;
import com.iotexample.demo.vo.SimpleMedicalRecord;
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

  @Autowired
  TreatmentDrugOrderService treatmentDrugOrderService;

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
      String hospitalName = departmentService.getHospitalNameByDepartmentId(mr.getDepartmentId());
      resList.add(new ResponseMedicalRecord(mr, addr, hospitalName));
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
  @CrossOrigin
  public Result<ResponseMedicalRecord2> getAllMedicalRecord2(@RequestParam("medicalRecordId") long medicalRecordId) {
    Medicalrecord medicalrecord = medicalRecordService.getMedicalRecordById(medicalRecordId);

    List<Examinationorder> list = examinationOrderService.getAllExaminationOrderByMedicalRecordId(medicalRecordId);

    return Result.success(new ResponseMedicalRecord2(medicalrecord, list));
  }

  @GetMapping("/web")
  @CrossOrigin
  public Result<MedicalRecordVo> getWebStyleMedicalRecord(@RequestParam("medicalRecordId") long medicalRecordId) {
    Medicalrecord medicalrecord = medicalRecordService.getMedicalRecordById(medicalRecordId);

    List<Examinationorder> list1 = examinationOrderService.getAllExaminationOrderByMedicalRecordId(medicalRecordId);

    List<TreatmentDrugOrder> list2 = treatmentDrugOrderService.getAllTreatmentDrugOrderByMedicalRecordId(medicalRecordId);

    List<SimpleMedicalRecord> list3 = medicalRecordService.getSimpleMedicalRecordByUserId(medicalrecord.getUserId());

    MedicalRecordVo medicalRecordVo = new MedicalRecordVo(medicalrecord, list1, list2, list3);

    return Result.success(medicalRecordVo);
  }
}
