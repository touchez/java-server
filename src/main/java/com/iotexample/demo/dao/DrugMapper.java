package com.iotexample.demo.dao;

import com.iotexample.demo.model.Drug;
import com.iotexample.demo.model.DrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface DrugMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    long countByExample(DrugExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int deleteByExample(DrugExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long drugId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int insert(Drug record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int insertSelective(Drug record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    List<Drug> selectByExampleWithRowbounds(DrugExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    List<Drug> selectByExample(DrugExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    Drug selectByPrimaryKey(Long drugId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Drug record, @Param("example") DrugExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Drug record, @Param("example") DrugExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Drug record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Drug record);
}