package com.iotexample.demo.service;

import com.iotexample.demo.dao.DepartmentMapper;
import com.iotexample.demo.model.Department;
import com.iotexample.demo.model.DepartmentExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iotdemo
 * @description: department service
 * @author: WenYuan
 * @create: 2019-05-23 09:29
 **/

@Service
@Slf4j
public class DepartmentService {
  @Autowired
  DepartmentMapper departmentMapper;

  public List<Department> listDepartment() {
    DepartmentExample departmentExample = new DepartmentExample();
    DepartmentExample.Criteria criteria = departmentExample.createCriteria();
    criteria.andDepartmentIdIsNotNull();

    List<Department>list = departmentMapper.selectByExample(departmentExample);
    //list.forEach(e -> log.info("select by example {}", e));

    return list;
  }

  public List<Department> listDepartmentByHospitalId(long hospitalId) {
    DepartmentExample departmentExample = new DepartmentExample();
    DepartmentExample.Criteria criteria = departmentExample.createCriteria();
    criteria.andHospitalIdEqualTo(hospitalId);

    List<Department>list = departmentMapper.selectByExample(departmentExample);
    //list.forEach(e -> log.info("select by example {}", e));

    return list;
  }

  public String getDepartmentNameById(long departmentId) {
    Department department = departmentMapper.selectByPrimaryKey(departmentId);

    String departmentName = department.getDepartmentName();

    return departmentName;
  }

}
