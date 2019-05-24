package com.iotexample.demo.dao;

import com.iotexample.demo.model.Doctor;
import com.iotexample.demo.model.DoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface DoctorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    long countByExample(DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int deleteByExample(DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long doctorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int insert(Doctor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int insertSelective(Doctor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    List<Doctor> selectByExampleWithRowbounds(DoctorExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    List<Doctor> selectByExample(DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    Doctor selectByPrimaryKey(Long doctorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Doctor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table doctor
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Doctor record);
}