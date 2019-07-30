package com.iotexample.demo.service;

import com.iotexample.demo.dao.ExaminationReportMapper;
import com.iotexample.demo.model.ExaminationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-07-30 22:30
 */

@Service
public class ExaminationReportService {

  @Autowired
  ExaminationReportMapper examinationReportMapper;

  public ExaminationReport add(ExaminationReport examinationReport) {
    if (examinationReport.getCreateDate() == null) {
      examinationReport.setCreateDate(new Date());
    }

    int res = examinationReportMapper.insertSelective(examinationReport);

    return examinationReport;
  }

  public ExaminationReport getById(long examinationReportId) {
    ExaminationReport res = examinationReportMapper.selectByPrimaryKey(examinationReportId);

    return res;
  }
}
