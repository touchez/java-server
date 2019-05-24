package com.iotexample.demo.service;

import com.iotexample.demo.dao.DoctorMapper;
import com.iotexample.demo.model.Doctor;
import com.iotexample.demo.model.DoctorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

/**
 * @program: iotdemo
 * @description: 医生service
 * @author: WenYuan
 * @create: 2019-05-23 17:14
 **/

@Service
public class DoctorService {
  @Autowired
  DoctorMapper doctorMapper;

  public Doctor getById(long doctorId) {
    return doctorMapper.selectByPrimaryKey(doctorId);
  }

  public long getOneByDepartment(long departmentId) {
    DoctorExample doctorExample = new DoctorExample();
    doctorExample.createCriteria().andDepartmentIdEqualTo(departmentId);

    List<Doctor> list = doctorMapper.selectByExample(doctorExample);
    long doctorId = 0;
    if (list.size() > 0) {
      doctorId = list.get(0).getDoctorId();
    }
    return doctorId;
  }
}
