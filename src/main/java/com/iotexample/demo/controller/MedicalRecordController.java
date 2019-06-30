package com.iotexample.demo.controller;

import com.iotexample.demo.RequestEntity.RequestMedicalRecord;
import com.iotexample.demo.RequestEntity.RequestNew;
import com.iotexample.demo.ResponseEntity.*;
import com.iotexample.demo.model.*;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.*;
import com.iotexample.demo.vo.MedicalRecordVo;
import com.iotexample.demo.vo.SimpleMedicalRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 病历的controller
 * @author: WenYuan
 * @create: 2019-06-02 21:26
 **/
@Slf4j
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

  @Autowired
  TreatmentService treatmentService;

  @Autowired
  ExaminationTypeService examinationTypeService;

  @Autowired
  ExaminationService examinationService;

  @Autowired
  DoctorService doctorService;

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

  @GetMapping("/lastRecord")
  @CrossOrigin
  public Result<List<SimpleMedicalRecord>> getLastRecordByUserId(@RequestParam("userId") long userId) {
    List<SimpleMedicalRecord> list3 = medicalRecordService.getSimpleMedicalRecordByUserId(userId);

    return Result.success(list3);
  }

  /**
  * @Description: 根据medicalRecordId来返回一串web页面所需的信息
  * @Param: [medicalRecordId]
  * @return: com.iotexample.demo.result.Result<com.iotexample.demo.vo.MedicalRecordVo>
  * @Author: WenYuan
  * @Date: 2019/6/22
  */
  @GetMapping("/web")
  @CrossOrigin
  public Result<ResponseMedicalRecord1> getWebStyleMedicalRecord(@RequestParam("medicalRecordId") long medicalRecordId) {

    // TODO 串行访问数据库导致速度较慢，可以通过使用多线程的方式来并行访问这几张表来提高速度

    log.info("medicalRecordId is " + medicalRecordId);


    Medicalrecord medicalrecord = medicalRecordService.getMedicalRecordById(medicalRecordId);

    List<ResponseSimpleExaminationType> list1 = examinationTypeService.getAllExaminationTypeByMedicalRecordId(medicalRecordId);

    List<TreatmentDrugOrder> list2 = treatmentDrugOrderService.getAllTreatmentDrugOrderByMedicalRecordId(medicalRecordId);

    List<SimpleMedicalRecord> list3 = medicalRecordService.getSimpleMedicalRecordByUserId(medicalrecord.getUserId());

    ResponseMedicalRecord1 responseMedicalRecord1 = new ResponseMedicalRecord1(medicalrecord, list1, list2, list3);

    return Result.success(responseMedicalRecord1);
  }

  @PostMapping("/web/post")
  @CrossOrigin
  public Result<Long> updateDBByPostData(@RequestBody RequestMedicalRecord requestMedicalRecord) {
    //TODO 同理可以多线程加速

    Medicalrecord medicalrecord = requestMedicalRecord.getMedicalrecord();

    long medicalRecordId = 0;
    long userId = 0;

    if (medicalrecord != null) {
      medicalRecordId = medicalRecordService.updateMedicalRecord(medicalrecord);
      userId = medicalrecord.getUserId();
    }

    List<ExaminationType> examinationTypes = examinationTypeService.getExaminationTypesByIds(requestMedicalRecord.getExaminationTypesId());

    if (examinationTypes != null) {
      //TODO 先插入到对应的子项目表中，再插入到收费的总表
      for (ExaminationType e : examinationTypes) {
        long examinationId = examinationService.insertExamnaitons(e, userId);
        int res2 = examinationOrderService.updateExaminationOrder(e, userId, medicalRecordId, examinationId, e.getExaminationTypeId());
      }

    }

    List<TreatmentDrugOrder> treatmentDrugOrders = requestMedicalRecord.getTreatmentDrugOrders();

    BigDecimal allCost = new BigDecimal(0);

    long treatmentId = -1;

    if (treatmentDrugOrders != null) {
      for (TreatmentDrugOrder t : treatmentDrugOrders) {
        allCost = allCost.add(t.getTotalPrice());
        if (t.getTreatmentId() != null) {
          treatmentId = t.getTreatmentId();
        }
      }
    }



    if (treatmentDrugOrders != null && treatmentDrugOrders.size() != 0) {
      if (treatmentId == -1) {
        log.info("treatmentId is " + treatmentId);
        treatmentId = treatmentService.insertTreatment(medicalrecord.getUserId(), allCost, medicalRecordId);
        int res = treatmentDrugOrderService.updateTreatmentDrugOrder(treatmentDrugOrders, treatmentId);
      }else {
        log.info("treatmentId is " + treatmentId);
        int res = treatmentService.updateTreatment(treatmentId, allCost);
        int res1 = treatmentDrugOrderService.updateTreatmentDrugOrder(treatmentDrugOrders, treatmentId);
      }

    }

    return Result.success(medicalRecordId);

  }

  @PostMapping("/web/new")
  @CrossOrigin
  public Result<ResponseNew> newOneMediacalRecord(@RequestBody RequestNew requestNew) {

    Medicalrecord medicalRecord = medicalRecordService.newOneMediacalRecord(requestNew);

    String departmentName = departmentService.getDepartmentNameById(medicalRecord.getDepartmentId());

    Doctor doctor = doctorService.getById(medicalRecord.getDoctorId());

    return Result.success(new ResponseNew(medicalRecord.getMedicalrecordId(), doctor.getDoctorName(), departmentName));
  }
}
