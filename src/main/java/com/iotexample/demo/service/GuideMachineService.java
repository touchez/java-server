package com.iotexample.demo.service;

import com.iotexample.demo.mongorepository.GuideMachine;
import com.iotexample.demo.mongorepository.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iotdemo
 * @description:
 * @author: WenYuan
 * @create: 2019-08-01 20:29
 */

@Service
public class GuideMachineService {
  @Autowired
  private MongoTemplate mongoTemplate;

  public List<GuideMachine> findByName(String name) {

    List<GuideMachine> list = mongoTemplate.find(
            Query.query(Criteria.where("name").is(name)), GuideMachine.class);
    //log.info("Find {} Medicine:", list.size());
    //list.forEach(c -> log.info("Medicine {}", c));

    return list;
  }

  public String addOrUpdate(GuideMachine guideMachine) {
    GuideMachine guideMachine1 = mongoTemplate.save(guideMachine);

    return guideMachine1.getGuideMachineId();
  }

  public List<GuideMachine> delete(String name) {
    //查询出符合条件的所有结果，并将符合条件的所有数据删除
    Query query = Query.query(Criteria.where("name").is(name));
    List<GuideMachine> guideMachines = mongoTemplate.findAllAndRemove(query, GuideMachine.class);

    return guideMachines;
  }

  public List<GuideMachine> findAll() {
    return mongoTemplate.findAll(GuideMachine.class);
  }
}
