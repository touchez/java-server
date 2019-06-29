package com.iotexample.demo.mymapper;

import com.iotexample.demo.model.Examinationorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface MyExaminationOrderMapper {

  @Select("SELECT * FROM examinationorder WHERE user_id = #{userId} AND time >= #{date} AND time < date_add(#{date}, interval '1 0 0 0' DAY_SECOND) ORDER BY time LIMIT 1000")
  public List<Examinationorder> getAllExaminationorderByUserIdAndDate(@Param("userId") long userId, @Param("date") Date date);

}
