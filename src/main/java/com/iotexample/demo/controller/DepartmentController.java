package com.iotexample.demo.controller;

import com.iotexample.demo.model.Department;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: iotdemo
 * @description: department controller
 * @author: WenYuan
 * @create: 2019-05-23 09:32
 **/
@RequestMapping("/departments")
@RestController
public class DepartmentController {
  @Autowired
  DepartmentService departmentService;
  
  /** 
  * @Description: 返回所有的科室信息 
  * @Param: [] 
  * @return: com.iotexample.demo.result.Result<java.util.List<com.iotexample.demo.model.Department>> 
  * @Author: WenYuan
  * @Date: 2019/5/24 
  */
  @GetMapping
  public Result<List<Department>> getAllDepartment() {
    List<Department> list = departmentService.listDepartment();
    return Result.success(list);
  }
  
  /** 
  * @Description: 放回对应hospitalId的科室信息 
  * @Param: [hospitalId] 
  * @return: com.iotexample.demo.result.Result<java.util.List<com.iotexample.demo.model.Department>> 
  * @Author: WenYuan
  * @Date: 2019/5/24 
  */
  @GetMapping("/{hospitalId}")
  public Result<List<Department>> getAllDepartmentByHospitalId(@PathVariable("hospitalId")long hospitalId) {
    List<Department> list = departmentService.listDepartmentByHospitalId(hospitalId);
    return Result.success(list);
  }

}
