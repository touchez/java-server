package com.iotexample.demo.service;

//
//import com.iotexample.demo.dao.JianchaMapper;
//import com.iotexample.demo.dao.JianchaorderMapper;
//import com.iotexample.demo.model.Jianchaorder;
//import com.iotexample.demo.model.JianchaorderExample;
//import com.iotexample.demo.mymapper.MyJianchaorderMapper;
//import com.iotexample.demo.vo.JiuzhenVo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @program: iotdemo
// * @description: 检查流水的service
// * @author: WenYuan
// * @create: 2019-05-23 18:03
// **/
//@Service
//@Slf4j
public class JianchaorderService {
//  @Autowired
//  JianchaorderMapper jianchaorderMapper;
//
//  @Autowired
//  MyJianchaorderMapper myJianchaorderMapper;
//
//  public int add(Jianchaorder jianchaorder) {
//    return jianchaorderMapper.insert(jianchaorder);
//  }
//
//  public int addAll(JiuzhenVo jiuzhenVo, long jiuzhenId) {
//    Long[] jianchaIds = jiuzhenVo.getJianchaIds();
//    log.info("jiuzhenId is {}", jiuzhenId);
//    int count = 0;
//    for (Long id : jianchaIds) {
//      Jianchaorder jianchaorder = new Jianchaorder()
//              .withJianchaId(id)
//              .withJiuzhenId(jiuzhenId)
//              .withUserId(jiuzhenVo.getUserId())
//              .withCreateDate(new Date());
//      count += add(jianchaorder);
//    }
//
//    return count;
//  }
//
//  public long getWaittingCount(long userId, long jianchaId) {
//
//    //获取到这个检查的条目
//    Jianchaorder jianchaorder = myJianchaorderMapper.getByUsedIdAndJianchaId(userId, jianchaId);
//
//    if (jianchaorder == null) {
//      return -1L;
//    }
//
//    Date date = jianchaorder.getCreateDate();
//
//    //找到这之前还没有检查过的数量为等待人数
//    JianchaorderExample jianchaorderExample = new JianchaorderExample();
//    jianchaorderExample.createCriteria()
//            .andJianchaIdEqualTo(jianchaId)
//            .andCreateDateLessThan(date)
//            .andStartDateIsNull();
//
//    long count = jianchaorderMapper.countByExample(jianchaorderExample);
//
//    return count;
//  }
//
//  //开始检查时更新startTime
//  public int updateState(long userId, long jianchaId) {
//    //获取到这个检查的条目
//    Jianchaorder jianchaorder = myJianchaorderMapper.getByUsedIdAndJianchaId(userId, jianchaId);
//
//    jianchaorder.setStartDate(new Date());
//
//    int res = jianchaorderMapper.updateByPrimaryKeySelective(jianchaorder);
//    return res;
//  }
//  public int updateState(Jianchaorder jianchaorder) {
//    jianchaorder.setStartDate(new Date());
//
//    int res = jianchaorderMapper.updateByPrimaryKeySelective(jianchaorder);
//    return res;
//  }
//
//  public long checkNext(long jianchaId) {
//    //找到下一个未检查的
//    Jianchaorder jianchaorder = myJianchaorderMapper.findNextByJianchaId(jianchaId);
//    int res = updateState(jianchaorder);
//    return jianchaorder.getJianchaorderId();
//  }
//
//  /**
//  * @Description: 根据userId获取所有检查项目
//  * @Param: [userId]
//  * @return: java.util.List<com.iotexample.demo.model.Jianchaorder>
//  * @Author: WenYuan
//  * @Date: 2019/6/2
//  */
//  public List<Jianchaorder> getJianchaByUserId(long userId) {
//    JianchaorderExample jianchaorderExample = new JianchaorderExample();
//    jianchaorderExample.createCriteria()
//            .andUserIdEqualTo(userId)
//            .andStartDateIsNull();//startDate为null的是未开始的检查
//
//    List<Jianchaorder> list = jianchaorderMapper.selectByExample(jianchaorderExample);
//    return list;
//  }
}
