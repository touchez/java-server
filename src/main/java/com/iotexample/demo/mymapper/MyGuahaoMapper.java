package com.iotexample.demo.mymapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: iotdemo
 * @description: 自定义删除挂号
 * @author: WenYuan
 * @create: 2019-07-03 22:07
 */

@Mapper
public interface MyGuahaoMapper {

  @Delete("DELETE FROM guahao WHERE user_id = #{userId}")
  public int deleteGuahaoByUserId(@Param("userId") long userId);
}
