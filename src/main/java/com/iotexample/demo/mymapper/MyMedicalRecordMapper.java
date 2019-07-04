package com.iotexample.demo.mymapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyMedicalRecordMapper {

  @Select("SELECT MAX(medicalRecord_id) FROM medicalrecord")
  public long getLatestMedicalRecordId();
}
