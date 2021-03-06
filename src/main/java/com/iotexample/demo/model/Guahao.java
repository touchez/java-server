package com.iotexample.demo.model;

import java.io.Serializable;
import java.util.Date;

public class Guahao implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.guahao_id
     *
     * @mbg.generated
     */
    private Long guahaoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.user_id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.department_id
     *
     * @mbg.generated
     */
    private Long departmentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.department_name
     *
     * @mbg.generated
     */
    private String departmentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.doctor_id
     *
     * @mbg.generated
     */
    private Long doctorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.end_date
     *
     * @mbg.generated
     */
    private Date endDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guahao.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table guahao
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.guahao_id
     *
     * @return the value of guahao.guahao_id
     *
     * @mbg.generated
     */
    public Long getGuahaoId() {
        return guahaoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withGuahaoId(Long guahaoId) {
        this.setGuahaoId(guahaoId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.guahao_id
     *
     * @param guahaoId the value for guahao.guahao_id
     *
     * @mbg.generated
     */
    public void setGuahaoId(Long guahaoId) {
        this.guahaoId = guahaoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.user_id
     *
     * @return the value of guahao.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withUserId(Long userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.user_id
     *
     * @param userId the value for guahao.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.department_id
     *
     * @return the value of guahao.department_id
     *
     * @mbg.generated
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withDepartmentId(Long departmentId) {
        this.setDepartmentId(departmentId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.department_id
     *
     * @param departmentId the value for guahao.department_id
     *
     * @mbg.generated
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.department_name
     *
     * @return the value of guahao.department_name
     *
     * @mbg.generated
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withDepartmentName(String departmentName) {
        this.setDepartmentName(departmentName);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.department_name
     *
     * @param departmentName the value for guahao.department_name
     *
     * @mbg.generated
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.doctor_id
     *
     * @return the value of guahao.doctor_id
     *
     * @mbg.generated
     */
    public Long getDoctorId() {
        return doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withDoctorId(Long doctorId) {
        this.setDoctorId(doctorId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.doctor_id
     *
     * @param doctorId the value for guahao.doctor_id
     *
     * @mbg.generated
     */
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.create_date
     *
     * @return the value of guahao.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.create_date
     *
     * @param createDate the value for guahao.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.end_date
     *
     * @return the value of guahao.end_date
     *
     * @mbg.generated
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withEndDate(Date endDate) {
        this.setEndDate(endDate);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.end_date
     *
     * @param endDate the value for guahao.end_date
     *
     * @mbg.generated
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guahao.state
     *
     * @return the value of guahao.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    public Guahao withState(Integer state) {
        this.setState(state);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guahao.state
     *
     * @param state the value for guahao.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guahao
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guahaoId=").append(guahaoId);
        sb.append(", userId=").append(userId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}