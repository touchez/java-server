package com.iotexample.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExaminationType implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column examination_type.examination_type_id
     *
     * @mbg.generated
     */
    private Long examinationTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column examination_type.examination_type_name
     *
     * @mbg.generated
     */
    private String examinationTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column examination_type.examination_type_detail
     *
     * @mbg.generated
     */
    private String examinationTypeDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column examination_type.examination_addr
     *
     * @mbg.generated
     */
    private String examinationAddr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column examination_type.examination_cost
     *
     * @mbg.generated
     */
    private BigDecimal examinationCost;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column examination_type.examination_type_id
     *
     * @return the value of examination_type.examination_type_id
     *
     * @mbg.generated
     */
    public Long getExaminationTypeId() {
        return examinationTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public ExaminationType withExaminationTypeId(Long examinationTypeId) {
        this.setExaminationTypeId(examinationTypeId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column examination_type.examination_type_id
     *
     * @param examinationTypeId the value for examination_type.examination_type_id
     *
     * @mbg.generated
     */
    public void setExaminationTypeId(Long examinationTypeId) {
        this.examinationTypeId = examinationTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column examination_type.examination_type_name
     *
     * @return the value of examination_type.examination_type_name
     *
     * @mbg.generated
     */
    public String getExaminationTypeName() {
        return examinationTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public ExaminationType withExaminationTypeName(String examinationTypeName) {
        this.setExaminationTypeName(examinationTypeName);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column examination_type.examination_type_name
     *
     * @param examinationTypeName the value for examination_type.examination_type_name
     *
     * @mbg.generated
     */
    public void setExaminationTypeName(String examinationTypeName) {
        this.examinationTypeName = examinationTypeName == null ? null : examinationTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column examination_type.examination_type_detail
     *
     * @return the value of examination_type.examination_type_detail
     *
     * @mbg.generated
     */
    public String getExaminationTypeDetail() {
        return examinationTypeDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public ExaminationType withExaminationTypeDetail(String examinationTypeDetail) {
        this.setExaminationTypeDetail(examinationTypeDetail);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column examination_type.examination_type_detail
     *
     * @param examinationTypeDetail the value for examination_type.examination_type_detail
     *
     * @mbg.generated
     */
    public void setExaminationTypeDetail(String examinationTypeDetail) {
        this.examinationTypeDetail = examinationTypeDetail == null ? null : examinationTypeDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column examination_type.examination_addr
     *
     * @return the value of examination_type.examination_addr
     *
     * @mbg.generated
     */
    public String getExaminationAddr() {
        return examinationAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public ExaminationType withExaminationAddr(String examinationAddr) {
        this.setExaminationAddr(examinationAddr);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column examination_type.examination_addr
     *
     * @param examinationAddr the value for examination_type.examination_addr
     *
     * @mbg.generated
     */
    public void setExaminationAddr(String examinationAddr) {
        this.examinationAddr = examinationAddr == null ? null : examinationAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column examination_type.examination_cost
     *
     * @return the value of examination_type.examination_cost
     *
     * @mbg.generated
     */
    public BigDecimal getExaminationCost() {
        return examinationCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public ExaminationType withExaminationCost(BigDecimal examinationCost) {
        this.setExaminationCost(examinationCost);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column examination_type.examination_cost
     *
     * @param examinationCost the value for examination_type.examination_cost
     *
     * @mbg.generated
     */
    public void setExaminationCost(BigDecimal examinationCost) {
        this.examinationCost = examinationCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examinationTypeId=").append(examinationTypeId);
        sb.append(", examinationTypeName=").append(examinationTypeName);
        sb.append(", examinationTypeDetail=").append(examinationTypeDetail);
        sb.append(", examinationAddr=").append(examinationAddr);
        sb.append(", examinationCost=").append(examinationCost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}