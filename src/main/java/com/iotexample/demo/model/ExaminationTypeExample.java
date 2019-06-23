package com.iotexample.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExaminationTypeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public ExaminationTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
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
     * This method corresponds to the database table examination_type
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
     * This method corresponds to the database table examination_type
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table examination_type
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
     * This class corresponds to the database table examination_type
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

        public Criteria andExaminationTypeNameIsNull() {
            addCriterion("examination_type_name is null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameIsNotNull() {
            addCriterion("examination_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameEqualTo(String value) {
            addCriterion("examination_type_name =", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameNotEqualTo(String value) {
            addCriterion("examination_type_name <>", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameGreaterThan(String value) {
            addCriterion("examination_type_name >", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("examination_type_name >=", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameLessThan(String value) {
            addCriterion("examination_type_name <", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameLessThanOrEqualTo(String value) {
            addCriterion("examination_type_name <=", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameLike(String value) {
            addCriterion("examination_type_name like", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameNotLike(String value) {
            addCriterion("examination_type_name not like", value, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameIn(List<String> values) {
            addCriterion("examination_type_name in", values, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameNotIn(List<String> values) {
            addCriterion("examination_type_name not in", values, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameBetween(String value1, String value2) {
            addCriterion("examination_type_name between", value1, value2, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeNameNotBetween(String value1, String value2) {
            addCriterion("examination_type_name not between", value1, value2, "examinationTypeName");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailIsNull() {
            addCriterion("examination_type_detail is null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailIsNotNull() {
            addCriterion("examination_type_detail is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailEqualTo(String value) {
            addCriterion("examination_type_detail =", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailNotEqualTo(String value) {
            addCriterion("examination_type_detail <>", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailGreaterThan(String value) {
            addCriterion("examination_type_detail >", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailGreaterThanOrEqualTo(String value) {
            addCriterion("examination_type_detail >=", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailLessThan(String value) {
            addCriterion("examination_type_detail <", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailLessThanOrEqualTo(String value) {
            addCriterion("examination_type_detail <=", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailLike(String value) {
            addCriterion("examination_type_detail like", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailNotLike(String value) {
            addCriterion("examination_type_detail not like", value, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailIn(List<String> values) {
            addCriterion("examination_type_detail in", values, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailNotIn(List<String> values) {
            addCriterion("examination_type_detail not in", values, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailBetween(String value1, String value2) {
            addCriterion("examination_type_detail between", value1, value2, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationTypeDetailNotBetween(String value1, String value2) {
            addCriterion("examination_type_detail not between", value1, value2, "examinationTypeDetail");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrIsNull() {
            addCriterion("examination_addr is null");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrIsNotNull() {
            addCriterion("examination_addr is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrEqualTo(String value) {
            addCriterion("examination_addr =", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrNotEqualTo(String value) {
            addCriterion("examination_addr <>", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrGreaterThan(String value) {
            addCriterion("examination_addr >", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrGreaterThanOrEqualTo(String value) {
            addCriterion("examination_addr >=", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrLessThan(String value) {
            addCriterion("examination_addr <", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrLessThanOrEqualTo(String value) {
            addCriterion("examination_addr <=", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrLike(String value) {
            addCriterion("examination_addr like", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrNotLike(String value) {
            addCriterion("examination_addr not like", value, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrIn(List<String> values) {
            addCriterion("examination_addr in", values, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrNotIn(List<String> values) {
            addCriterion("examination_addr not in", values, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrBetween(String value1, String value2) {
            addCriterion("examination_addr between", value1, value2, "examinationAddr");
            return (Criteria) this;
        }

        public Criteria andExaminationAddrNotBetween(String value1, String value2) {
            addCriterion("examination_addr not between", value1, value2, "examinationAddr");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table examination_type
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
     * This class corresponds to the database table examination_type
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