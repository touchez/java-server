package com.iotexample.demo.controller;

import com.iotexample.demo.model.Department;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: iotdemo
 * @description: department controller
 * @author: WenYuan
 * @create: 2019-05-23 09:32
 **/
@RequestMapping("/department")
@Controller
public class DepartmentController {
  @Autowired
  DepartmentService departmentService;

  @RequestMapping("/all")
  @ResponseBody
  public Result<List<Department>> getAllDepartment() {
    List<Department> list = departmentService.listDepartment();
    return Result.success(list);
  }

  @RequestMapping("/{hospitalId}")
  @ResponseBody
  public Result<List<Department>> getAllDepartmentByHospitalId(@PathVariable("hospitalId")long hospitalId) {
    List<Department> list = departmentService.listDepartmentByHospitalId(hospitalId);
    return Result.success(list);
  }

}
