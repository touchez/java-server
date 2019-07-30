package com.iotexample.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExaminationorderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public ExaminationorderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andExaminationorderIdIsNull() {
            addCriterion("examinationOrder_id is null");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdIsNotNull() {
            addCriterion("examinationOrder_id is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdEqualTo(Long value) {
            addCriterion("examinationOrder_id =", value, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdNotEqualTo(Long value) {
            addCriterion("examinationOrder_id <>", value, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdGreaterThan(Long value) {
            addCriterion("examinationOrder_id >", value, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("examinationOrder_id >=", value, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdLessThan(Long value) {
            addCriterion("examinationOrder_id <", value, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdLessThanOrEqualTo(Long value) {
            addCriterion("examinationOrder_id <=", value, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdIn(List<Long> values) {
            addCriterion("examinationOrder_id in", values, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdNotIn(List<Long> values) {
            addCriterion("examinationOrder_id not in", values, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdBetween(Long value1, Long value2) {
            addCriterion("examinationOrder_id between", value1, value2, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andExaminationorderIdNotBetween(Long value1, Long value2) {
            addCriterion("examinationOrder_id not between", value1, value2, "examinationorderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdIsNull() {
            addCriterion("medicalRecord_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdIsNotNull() {
            addCriterion("medicalRecord_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdEqualTo(Long value) {
            addCriterion("medicalRecord_id =", value, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdNotEqualTo(Long value) {
            addCriterion("medicalRecord_id <>", value, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdGreaterThan(Long value) {
            addCriterion("medicalRecord_id >", value, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("medicalRecord_id >=", value, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdLessThan(Long value) {
            addCriterion("medicalRecord_id <", value, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdLessThanOrEqualTo(Long value) {
            addCriterion("medicalRecord_id <=", value, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdIn(List<Long> values) {
            addCriterion("medicalRecord_id in", values, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdNotIn(List<Long> values) {
            addCriterion("medicalRecord_id not in", values, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdBetween(Long value1, Long value2) {
            addCriterion("medicalRecord_id between", value1, value2, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordIdNotBetween(Long value1, Long value2) {
            addCriterion("medicalRecord_id not between", value1, value2, "medicalrecordId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdIsNull() {
            addCriterion("examination_id is null");
            return (Criteria) this;
        }

        public Criteria andExaminationIdIsNotNull() {
            addCriterion("examination_id is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationIdEqualTo(Long value) {
            addCriterion("examination_id =", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdNotEqualTo(Long value) {
            addCriterion("examination_id <>", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdGreaterThan(Long value) {
            addCriterion("examination_id >", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("examination_id >=", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdLessThan(Long value) {
            addCriterion("examination_id <", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdLessThanOrEqualTo(Long value) {
            addCriterion("examination_id <=", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdIn(List<Long> values) {
            addCriterion("examination_id in", values, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdNotIn(List<Long> values) {
            addCriterion("examination_id not in", values, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdBetween(Long value1, Long value2) {
            addCriterion("examination_id between", value1, value2, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdNotBetween(Long value1, Long value2) {
            addCriterion("examination_id not between", value1, value2, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIsNull() {
            addCriterion("examination_type is null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIsNotNull() {
            addCriterion("examination_type is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeEqualTo(String value) {
            addCriterion("examination_type =", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotEqualTo(String value) {
            addCriterion("examination_type <>", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeGreaterThan(String value) {
            addCriterion("examination_type >", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("examination_type >=", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeLessThan(String value) {
            addCriterion("examination_type <", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeLessThanOrEqualTo(String value) {
            addCriterion("examination_type <=", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeLike(String value) {
            addCriterion("examination_type like", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotLike(String value) {
            addCriterion("examination_type not like", value, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIn(List<String> values) {
            addCriterion("examination_type in", values, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotIn(List<String> values) {
            addCriterion("examination_type not in", values, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeBetween(String value1, String value2) {
            addCriterion("examination_type between", value1, value2, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNotBetween(String value1, String value2) {
            addCriterion("examination_type not between", value1, value2, "examinationType");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdIsNull() {
            addCriterion("examination_type_id is null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdIsNotNull() {
            addCriterion("examination_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdEqualTo(Long value) {
            addCriterion("examination_type_id =", value, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdNotEqualTo(Long value) {
            addCriterion("examination_type_id <>", value, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdGreaterThan(Long value) {
            addCriterion("examination_type_id >", value, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("examination_type_id >=", value, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdLessThan(Long value) {
            addCriterion("examination_type_id <", value, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("examination_type_id <=", value, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdIn(List<Long> values) {
            addCriterion("examination_type_id in", values, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdNotIn(List<Long> values) {
            addCriterion("examination_type_id not in", values, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdBetween(Long value1, Long value2) {
            addCriterion("examination_type_id between", value1, value2, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("examination_type_id not between", value1, value2, "examinationTypeId");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andExaminationCostIsNull() {
            addCriterion("examination_cost is null");
            return (Criteria) this;
        }

        public Criteria andExaminationCostIsNotNull() {
            addCriterion("examination_cost is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationCostEqualTo(BigDecimal value) {
            addCriterion("examination_cost =", value, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostNotEqualTo(BigDecimal value) {
            addCriterion("examination_cost <>", value, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostGreaterThan(BigDecimal value) {
            addCriterion("examination_cost >", value, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("examination_cost >=", value, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostLessThan(BigDecimal value) {
            addCriterion("examination_cost <", value, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("examination_cost <=", value, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostIn(List<BigDecimal> values) {
            addCriterion("examination_cost in", values, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostNotIn(List<BigDecimal> values) {
            addCriterion("examination_cost not in", values, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("examination_cost between", value1, value2, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andExaminationCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("examination_cost not between", value1, value2, "examinationCost");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("`time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("`time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("`time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("`time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("`time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("`time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("`time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("`time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("`time` not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Integer value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Integer value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Integer value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Integer value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Integer> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Integer> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Integer value1, Integer value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table examinationorder
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table examinationorder
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}