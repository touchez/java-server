package com.iotexample.demo.dao;

import com.iotexample.demo.model.ExaminationReport;
import com.iotexample.demo.model.ExaminationReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface ExaminationReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    long countByExample(ExaminationReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int deleteByExample(ExaminationReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long examinationReportId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int insert(ExaminationReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int insertSelective(ExaminationReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    List<ExaminationReport> selectByExampleWithBLOBsWithRowbounds(ExaminationReportExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    List<ExaminationReport> selectByExampleWithBLOBs(ExaminationReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    List<ExaminationReport> selectByExampleWithRowbounds(ExaminationReportExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    List<ExaminationReport> selectByExample(ExaminationReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    ExaminationReport selectByPrimaryKey(Long examinationReportId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ExaminationReport record, @Param("example") ExaminationReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") ExaminationReport record, @Param("example") ExaminationReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ExaminationReport record, @Param("example") ExaminationReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ExaminationReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(ExaminationReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_report
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ExaminationReport record);
}