package com.iotexample.demo.service;

import com.iotexample.demo.dao.DrugMapper;
import com.iotexample.demo.model.Drug;
import com.iotexample.demo.model.DrugExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iotdemo
 * @description: drug的service
 * @author: WenYuan
 * @create: 2019-06-22 16:17
 */

@Service
public class DrugService {

  @Autowired
  DrugMapper drugMapper;

  public List<Drug> getAllDrugs() {
    DrugExample drugExample = new DrugExample();
    drugExample.createCriteria();

    List<Drug> list = drugMapper.selectByExample(drugExample);
    return list;
  }
}
