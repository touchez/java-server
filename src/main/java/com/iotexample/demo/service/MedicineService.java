package com.iotexample.demo.service;

import com.iotexample.demo.mongorepository.MedicalHistory;
import com.iotexample.demo.mongorepository.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iotdemo
 * @description: 调用mongodb内的药品信息
 * @author: WenYuan
 * @create: 2019-08-01 16:15
 */

@Service
public class MedicineService {
  @Autowired
  private MongoTemplate mongoTemplate;

  public List<Medicine> findByName(String medicineName) {

    List<Medicine> list = mongoTemplate.find(
            Query.query(Criteria.where("medicineName").is(medicineName)), Medicine.class);
    //log.info("Find {} Medicine:", list.size());
    //list.forEach(c -> log.info("Medicine {}", c));

    return list;
  }

  public String addOrUpdate(Medicine medicine) {
    Medicine medicine1 = mongoTemplate.save(medicine);

    return medicine1.getMedicineId();
  }

  public List<Medicine> delete(String medicineName) {
    //查询出符合条件的所有结果，并将符合条件的所有数据删除
    Query query = Query.query(Criteria.where("medicineName").is(medicineName));
    List<Medicine> medicines = mongoTemplate.findAllAndRemove(query, Medicine.class);

    return medicines;
  }

  public List<Medicine> findAll() {
    return mongoTemplate.findAll(Medicine.class);
  }
}
