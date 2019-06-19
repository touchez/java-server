package com.iotexample.demo.mymapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

@Mapper
public interface MyPayMapper {

  @Update("UPDATE user SET user_balance = user_balance - #{price} WHERE user_id = #{userId} AND user_balance >= #{price} ")
  public int subBalance(@Param("userId") long userId, @Param("price") BigDecimal price);

  @Update("UPDATE user SET user_balance = user_balance + #{price} WHERE user_id = #{userId}")
  public int addBalance(@Param("userId") long userId, @Param("price") BigDecimal price);


  @Update("UPDATE examinationorder SET pay_state = 1 WHERE examinationorder_id = #{examinationorderId} AND pay_state = 0 ")
  public int payExamination(@Param("examinationorderId") long examinationorderId);


  @Update("UPDATE treatment SET pay_state = 1 WHERE treatment_id = #{treatmentId} AND pay_state = 0 ")
  public int payTreatment(@Param("treatmentId") long treatmentId);
}
