package com.iotexample.demo.controller;

import com.iotexample.demo.model.Drug;
import com.iotexample.demo.result.Result;
import com.iotexample.demo.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: iotdemo
 * @description: drug类的controller
 * @author: WenYuan
 * @create: 2019-06-22 16:15
 */

@RestController
@RequestMapping("/drug")
public class DrugController {

  @Autowired
  DrugService drugService;

  /** 
  * @Description: 获取所有的药品信息
  * @Param: [] 
  * @return: com.iotexample.demo.result.Result<java.util.List<com.iotexample.demo.model.Drug>> 
  * @Author: WenYuan
  * @Date: 2019/6/22 
  */
  @GetMapping("/all")
  public Result<List<Drug>> getAllDrugs() {
    List<Drug> list = drugService.getAllDrugs();
    
    return Result.success(list);
  }

}
