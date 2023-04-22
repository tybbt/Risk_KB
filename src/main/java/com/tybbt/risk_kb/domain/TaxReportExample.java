package com.tybbt.risk_kb.domain;

import java.util.ArrayList;
import java.util.List;

public class TaxReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaxReportExample() {
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

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andTaxIdIsNull() {
            addCriterion("tax_id is null");
            return (Criteria) this;
        }

        public Criteria andTaxIdIsNotNull() {
            addCriterion("tax_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaxIdEqualTo(Long value) {
            addCriterion("tax_id =", value, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdNotEqualTo(Long value) {
            addCriterion("tax_id <>", value, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdGreaterThan(Long value) {
            addCriterion("tax_id >", value, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tax_id >=", value, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdLessThan(Long value) {
            addCriterion("tax_id <", value, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdLessThanOrEqualTo(Long value) {
            addCriterion("tax_id <=", value, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdIn(List<Long> values) {
            addCriterion("tax_id in", values, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdNotIn(List<Long> values) {
            addCriterion("tax_id not in", values, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdBetween(Long value1, Long value2) {
            addCriterion("tax_id between", value1, value2, "taxId");
            return (Criteria) this;
        }

        public Criteria andTaxIdNotBetween(Long value1, Long value2) {
            addCriterion("tax_id not between", value1, value2, "taxId");
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