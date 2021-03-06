package com.iotexample.demo.dao;

import com.iotexample.demo.model.Treatment;
import com.iotexample.demo.model.TreatmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TreatmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    long countByExample(TreatmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int deleteByExample(TreatmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long treatmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int insert(Treatment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int insertSelective(Treatment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    List<Treatment> selectByExampleWithRowbounds(TreatmentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    List<Treatment> selectByExample(TreatmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    Treatment selectByPrimaryKey(Long treatmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Treatment record, @Param("example") TreatmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Treatment record, @Param("example") TreatmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Treatment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table treatment
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Treatment record);
}