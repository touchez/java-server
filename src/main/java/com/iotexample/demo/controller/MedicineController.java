package com.iotexample.demo.controller;

import com.iotexample.demo.mongorepository.Medicine;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 简单增删改查药品的接口，这个接口仅用于小程序显示药品信息用
 * @author: WenYuan
 * @create: 2019-08-01 16:14
 */

@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineController {

  @Autowired
  MedicineService medicineService;

  @GetMapping
  public Result<List<Medicine>> getMedicineByName(@RequestParam("medicineName") String medicineName) {

    return Result.success(medicineService.findByName(medicineName));
  }

  @PostMapping
  public Result<String> addMedicine(@RequestBody Medicine medicine) {

    return Result.success(medicineService.addOrUpdate(medicine));
  }

  @DeleteMapping
  public Result<List<Medicine>> removeMedicineByName(@RequestBody String[] names) {
    List<Medicine> removed = new ArrayList<>();

    for (String str : names) {
      removed.addAll(medicineService.delete(str));
    }

    return Result.success(removed);
  }

  @GetMapping("/all")
  public Result<List<Medicine>> findAllMedicine() {
    return Result.success(medicineService.findAll());
  }

}
