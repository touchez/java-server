package com.iotexample.demo.controller;

import com.iotexample.demo.mongorepository.GuideMachine;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.GuideMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-08-01 20:33
 */
@RestController
@RequestMapping("/api/v1/guideMachine")
public class GuideMachineController {

  @Autowired
  GuideMachineService guideMachineService;

  @GetMapping
  public Result<List<GuideMachine>> getMedicineByName(@RequestParam("guideMachineName") String guideMachineName) {

    return Result.success(guideMachineService.findByName(guideMachineName));
  }

  @PostMapping
  public Result<String> addMedicine(@RequestBody GuideMachine guideMachine) {

    if (guideMachine.getCreateDate() == null) {
      guideMachine.setCreateDate(new Date());
    }

    return Result.success(guideMachineService.addOrUpdate(guideMachine));
  }

  @DeleteMapping
  public Result<List<GuideMachine>> removeMedicineByName(@RequestBody String[] names) {
    List<GuideMachine> removed = new ArrayList<>();

    for (String str : names) {
      removed.addAll(guideMachineService.delete(str));
    }

    return Result.success(removed);
  }

  @GetMapping("/all")
  public Result<List<GuideMachine>> findAllMedicine() {
    return Result.success(guideMachineService.findAll());
  }

}
