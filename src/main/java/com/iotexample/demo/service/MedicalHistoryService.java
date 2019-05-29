package com.iotexample.demo.service;

import com.iotexample.demo.mongorepository.MedicalHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iotdemo
 * @description: 病史的service
 * @author: WenYuan
 * @create: 2019-05-28 17:18
 **/

@Service
@Slf4j
public class MedicalHistoryService {
  @Autowired
  private MongoTemplate mongoTemplate;

  public List<MedicalHistory> findAllByUser(String user) {
    //返回日期降序
    Sort sort = new Sort(Sort.Direction.DESC, "date");
    List<MedicalHistory> list = mongoTemplate.find(
            Query.query(Criteria.where("user").is(user)).with(sort),MedicalHistory.class);
    log.info("Find {} MedicalHistory:", list.size());
    list.forEach(c -> log.info("MedicalHistory {}", c));

    return list;
  }

  public String add(MedicalHistory medicalHistory) {
    MedicalHistory medicalHistory1 = mongoTemplate.save(medicalHistory);
    log.info("Insert MedicalHistory {}", medicalHistory1);

    return medicalHistory1.getId();
  }
}
