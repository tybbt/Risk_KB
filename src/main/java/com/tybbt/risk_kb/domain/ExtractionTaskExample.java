package com.tybbt.risk_kb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExtractionTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExtractionTaskExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andActivateTimeIsNull() {
            addCriterion("activate_time is null");
            return (Criteria) this;
        }

        public Criteria andActivateTimeIsNotNull() {
            addCriterion("activate_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("activate_time =", value, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("activate_time <>", value, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("activate_time >", value, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("activate_time >=", value, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeLessThan(Date value) {
            addCriterionForJDBCDate("activate_time <", value, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("activate_time <=", value, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("activate_time in", values, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("activate_time not in", values, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("activate_time between", value1, value2, "activateTime");
            return (Criteria) this;
        }

        public Criteria andActivateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("activate_time not between", value1, value2, "activateTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterionForJDBCDate("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterionForJDBCDate("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterionForJDBCDate("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(Long value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(Long value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(Long value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(Long value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(Long value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(Long value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<Long> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<Long> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(Long value1, Long value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(Long value1, Long value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andReviewer1IsNull() {
            addCriterion("reviewer1 is null");
            return (Criteria) this;
        }

        public Criteria andReviewer1IsNotNull() {
            addCriterion("reviewer1 is not null");
            return (Criteria) this;
        }

        public Criteria andReviewer1EqualTo(Long value) {
            addCriterion("reviewer1 =", value, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1NotEqualTo(Long value) {
            addCriterion("reviewer1 <>", value, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1GreaterThan(Long value) {
            addCriterion("reviewer1 >", value, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1GreaterThanOrEqualTo(Long value) {
            addCriterion("reviewer1 >=", value, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1LessThan(Long value) {
            addCriterion("reviewer1 <", value, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1LessThanOrEqualTo(Long value) {
            addCriterion("reviewer1 <=", value, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1In(List<Long> values) {
            addCriterion("reviewer1 in", values, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1NotIn(List<Long> values) {
            addCriterion("reviewer1 not in", values, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1Between(Long value1, Long value2) {
            addCriterion("reviewer1 between", value1, value2, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer1NotBetween(Long value1, Long value2) {
            addCriterion("reviewer1 not between", value1, value2, "reviewer1");
            return (Criteria) this;
        }

        public Criteria andReviewer2IsNull() {
            addCriterion("reviewer2 is null");
            return (Criteria) this;
        }

        public Criteria andReviewer2IsNotNull() {
            addCriterion("reviewer2 is not null");
            return (Criteria) this;
        }

        public Criteria andReviewer2EqualTo(Long value) {
            addCriterion("reviewer2 =", value, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2NotEqualTo(Long value) {
            addCriterion("reviewer2 <>", value, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2GreaterThan(Long value) {
            addCriterion("reviewer2 >", value, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2GreaterThanOrEqualTo(Long value) {
            addCriterion("reviewer2 >=", value, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2LessThan(Long value) {
            addCriterion("reviewer2 <", value, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2LessThanOrEqualTo(Long value) {
            addCriterion("reviewer2 <=", value, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2In(List<Long> values) {
            addCriterion("reviewer2 in", values, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2NotIn(List<Long> values) {
            addCriterion("reviewer2 not in", values, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2Between(Long value1, Long value2) {
            addCriterion("reviewer2 between", value1, value2, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer2NotBetween(Long value1, Long value2) {
            addCriterion("reviewer2 not between", value1, value2, "reviewer2");
            return (Criteria) this;
        }

        public Criteria andReviewer3IsNull() {
            addCriterion("reviewer3 is null");
            return (Criteria) this;
        }

        public Criteria andReviewer3IsNotNull() {
            addCriterion("reviewer3 is not null");
            return (Criteria) this;
        }

        public Criteria andReviewer3EqualTo(Long value) {
            addCriterion("reviewer3 =", value, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3NotEqualTo(Long value) {
            addCriterion("reviewer3 <>", value, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3GreaterThan(Long value) {
            addCriterion("reviewer3 >", value, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3GreaterThanOrEqualTo(Long value) {
            addCriterion("reviewer3 >=", value, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3LessThan(Long value) {
            addCriterion("reviewer3 <", value, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3LessThanOrEqualTo(Long value) {
            addCriterion("reviewer3 <=", value, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3In(List<Long> values) {
            addCriterion("reviewer3 in", values, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3NotIn(List<Long> values) {
            addCriterion("reviewer3 not in", values, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3Between(Long value1, Long value2) {
            addCriterion("reviewer3 between", value1, value2, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andReviewer3NotBetween(Long value1, Long value2) {
            addCriterion("reviewer3 not between", value1, value2, "reviewer3");
            return (Criteria) this;
        }

        public Criteria andRelationParamsIsNull() {
            addCriterion("relation_params is null");
            return (Criteria) this;
        }

        public Criteria andRelationParamsIsNotNull() {
            addCriterion("relation_params is not null");
            return (Criteria) this;
        }

        public Criteria andRelationParamsEqualTo(String value) {
            addCriterion("relation_params =", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsNotEqualTo(String value) {
            addCriterion("relation_params <>", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsGreaterThan(String value) {
            addCriterion("relation_params >", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsGreaterThanOrEqualTo(String value) {
            addCriterion("relation_params >=", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsLessThan(String value) {
            addCriterion("relation_params <", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsLessThanOrEqualTo(String value) {
            addCriterion("relation_params <=", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsLike(String value) {
            addCriterion("relation_params like", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsNotLike(String value) {
            addCriterion("relation_params not like", value, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsIn(List<String> values) {
            addCriterion("relation_params in", values, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsNotIn(List<String> values) {
            addCriterion("relation_params not in", values, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsBetween(String value1, String value2) {
            addCriterion("relation_params between", value1, value2, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationParamsNotBetween(String value1, String value2) {
            addCriterion("relation_params not between", value1, value2, "relationParams");
            return (Criteria) this;
        }

        public Criteria andRelationValuesIsNull() {
            addCriterion("relation_values is null");
            return (Criteria) this;
        }

        public Criteria andRelationValuesIsNotNull() {
            addCriterion("relation_values is not null");
            return (Criteria) this;
        }

        public Criteria andRelationValuesEqualTo(String value) {
            addCriterion("relation_values =", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesNotEqualTo(String value) {
            addCriterion("relation_values <>", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesGreaterThan(String value) {
            addCriterion("relation_values >", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesGreaterThanOrEqualTo(String value) {
            addCriterion("relation_values >=", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesLessThan(String value) {
            addCriterion("relation_values <", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesLessThanOrEqualTo(String value) {
            addCriterion("relation_values <=", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesLike(String value) {
            addCriterion("relation_values like", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesNotLike(String value) {
            addCriterion("relation_values not like", value, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesIn(List<String> values) {
            addCriterion("relation_values in", values, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesNotIn(List<String> values) {
            addCriterion("relation_values not in", values, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesBetween(String value1, String value2) {
            addCriterion("relation_values between", value1, value2, "relationValues");
            return (Criteria) this;
        }

        public Criteria andRelationValuesNotBetween(String value1, String value2) {
            addCriterion("relation_values not between", value1, value2, "relationValues");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

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