package com.webcc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeauserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeauserExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTeanameIsNull() {
            addCriterion("teaName is null");
            return (Criteria) this;
        }

        public Criteria andTeanameIsNotNull() {
            addCriterion("teaName is not null");
            return (Criteria) this;
        }

        public Criteria andTeanameEqualTo(String value) {
            addCriterion("teaName =", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameNotEqualTo(String value) {
            addCriterion("teaName <>", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameGreaterThan(String value) {
            addCriterion("teaName >", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameGreaterThanOrEqualTo(String value) {
            addCriterion("teaName >=", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameLessThan(String value) {
            addCriterion("teaName <", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameLessThanOrEqualTo(String value) {
            addCriterion("teaName <=", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameLike(String value) {
            addCriterion("teaName like", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameNotLike(String value) {
            addCriterion("teaName not like", value, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameIn(List<String> values) {
            addCriterion("teaName in", values, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameNotIn(List<String> values) {
            addCriterion("teaName not in", values, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameBetween(String value1, String value2) {
            addCriterion("teaName between", value1, value2, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanameNotBetween(String value1, String value2) {
            addCriterion("teaName not between", value1, value2, "teaname");
            return (Criteria) this;
        }

        public Criteria andTeanoIsNull() {
            addCriterion("teaNo is null");
            return (Criteria) this;
        }

        public Criteria andTeanoIsNotNull() {
            addCriterion("teaNo is not null");
            return (Criteria) this;
        }

        public Criteria andTeanoEqualTo(String value) {
            addCriterion("teaNo =", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoNotEqualTo(String value) {
            addCriterion("teaNo <>", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoGreaterThan(String value) {
            addCriterion("teaNo >", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoGreaterThanOrEqualTo(String value) {
            addCriterion("teaNo >=", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoLessThan(String value) {
            addCriterion("teaNo <", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoLessThanOrEqualTo(String value) {
            addCriterion("teaNo <=", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoLike(String value) {
            addCriterion("teaNo like", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoNotLike(String value) {
            addCriterion("teaNo not like", value, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoIn(List<String> values) {
            addCriterion("teaNo in", values, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoNotIn(List<String> values) {
            addCriterion("teaNo not in", values, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoBetween(String value1, String value2) {
            addCriterion("teaNo between", value1, value2, "teano");
            return (Criteria) this;
        }

        public Criteria andTeanoNotBetween(String value1, String value2) {
            addCriterion("teaNo not between", value1, value2, "teano");
            return (Criteria) this;
        }

        public Criteria andTeasexIsNull() {
            addCriterion("teaSex is null");
            return (Criteria) this;
        }

        public Criteria andTeasexIsNotNull() {
            addCriterion("teaSex is not null");
            return (Criteria) this;
        }

        public Criteria andTeasexEqualTo(Integer value) {
            addCriterion("teaSex =", value, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexNotEqualTo(Integer value) {
            addCriterion("teaSex <>", value, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexGreaterThan(Integer value) {
            addCriterion("teaSex >", value, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexGreaterThanOrEqualTo(Integer value) {
            addCriterion("teaSex >=", value, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexLessThan(Integer value) {
            addCriterion("teaSex <", value, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexLessThanOrEqualTo(Integer value) {
            addCriterion("teaSex <=", value, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexIn(List<Integer> values) {
            addCriterion("teaSex in", values, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexNotIn(List<Integer> values) {
            addCriterion("teaSex not in", values, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexBetween(Integer value1, Integer value2) {
            addCriterion("teaSex between", value1, value2, "teasex");
            return (Criteria) this;
        }

        public Criteria andTeasexNotBetween(Integer value1, Integer value2) {
            addCriterion("teaSex not between", value1, value2, "teasex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
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