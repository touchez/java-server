package com.iotexample.demo.service;

import com.iotexample.demo.DemoApplication;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = DemoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@DirtiesContext
public class ExaminationTypeServiceTest {

  @Autowired
  ExaminationTypeService examinationTypeService;

  @Test
  public void getAllExaminationTypeByUserIdAndDate() {
    Date d = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    try {
      d = sdf.parse("2019-06-29");
    } catch (Exception e) {
      e.printStackTrace();
    }

    examinationTypeService.getAllExaminationTypeByUserIdAndDate(1, d);
  }
}