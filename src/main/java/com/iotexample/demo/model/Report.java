package com.iotexample.demo.model;

import java.io.Serializable;

public class Report implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.report_id
     *
     * @mbg.generated
     */
    private Long reportId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.user_id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.jianchaOrder_id
     *
     * @mbg.generated
     */
    private Long jianchaorderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.report_content
     *
     * @mbg.generated
     */
    private String reportContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table report
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.report_id
     *
     * @return the value of report.report_id
     *
     * @mbg.generated
     */
    public Long getReportId() {
        return reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated
     */
    public Report withReportId(Long reportId) {
        this.setReportId(reportId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.report_id
     *
     * @param reportId the value for report.report_id
     *
     * @mbg.generated
     */
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.user_id
     *
     * @return the value of report.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated
     */
    public Report withUserId(Long userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.user_id
     *
     * @param userId the value for report.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.jianchaOrder_id
     *
     * @return the value of report.jianchaOrder_id
     *
     * @mbg.generated
     */
    public Long getJianchaorderId() {
        return jianchaorderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated
     */
    public Report withJianchaorderId(Long jianchaorderId) {
        this.setJianchaorderId(jianchaorderId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.jianchaOrder_id
     *
     * @param jianchaorderId the value for report.jianchaOrder_id
     *
     * @mbg.generated
     */
    public void setJianchaorderId(Long jianchaorderId) {
        this.jianchaorderId = jianchaorderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.report_content
     *
     * @return the value of report.report_content
     *
     * @mbg.generated
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated
     */
    public Report withReportContent(String reportContent) {
        this.setReportContent(reportContent);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.report_content
     *
     * @param reportContent the value for report.report_content
     *
     * @mbg.generated
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reportId=").append(reportId);
        sb.append(", userId=").append(userId);
        sb.append(", jianchaorderId=").append(jianchaorderId);
        sb.append(", reportContent=").append(reportContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}