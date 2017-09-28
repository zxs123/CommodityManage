package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class ExpressInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpressInfoExample() {
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

        public Criteria andOrderNumIsNull() {
            addCriterion("Order_Num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("Order_Num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("Order_Num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("Order_Num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("Order_Num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("Order_Num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("Order_Num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("Order_Num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("Order_Num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("Order_Num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("Order_Num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("Order_Num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("Order_Num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("Order_Num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumIsNull() {
            addCriterion("Express_Num is null");
            return (Criteria) this;
        }

        public Criteria andExpressNumIsNotNull() {
            addCriterion("Express_Num is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNumEqualTo(String value) {
            addCriterion("Express_Num =", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumNotEqualTo(String value) {
            addCriterion("Express_Num <>", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumGreaterThan(String value) {
            addCriterion("Express_Num >", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumGreaterThanOrEqualTo(String value) {
            addCriterion("Express_Num >=", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumLessThan(String value) {
            addCriterion("Express_Num <", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumLessThanOrEqualTo(String value) {
            addCriterion("Express_Num <=", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumLike(String value) {
            addCriterion("Express_Num like", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumNotLike(String value) {
            addCriterion("Express_Num not like", value, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumIn(List<String> values) {
            addCriterion("Express_Num in", values, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumNotIn(List<String> values) {
            addCriterion("Express_Num not in", values, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumBetween(String value1, String value2) {
            addCriterion("Express_Num between", value1, value2, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressNumNotBetween(String value1, String value2) {
            addCriterion("Express_Num not between", value1, value2, "expressNum");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNull() {
            addCriterion("Express_Company is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNotNull() {
            addCriterion("Express_Company is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyEqualTo(String value) {
            addCriterion("Express_Company =", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("Express_Company <>", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThan(String value) {
            addCriterion("Express_Company >", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("Express_Company >=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThan(String value) {
            addCriterion("Express_Company <", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("Express_Company <=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLike(String value) {
            addCriterion("Express_Company like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotLike(String value) {
            addCriterion("Express_Company not like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIn(List<String> values) {
            addCriterion("Express_Company in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotIn(List<String> values) {
            addCriterion("Express_Company not in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("Express_Company between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("Express_Company not between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCostIsNull() {
            addCriterion("Express_Cost is null");
            return (Criteria) this;
        }

        public Criteria andExpressCostIsNotNull() {
            addCriterion("Express_Cost is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCostEqualTo(Double value) {
            addCriterion("Express_Cost =", value, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostNotEqualTo(Double value) {
            addCriterion("Express_Cost <>", value, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostGreaterThan(Double value) {
            addCriterion("Express_Cost >", value, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostGreaterThanOrEqualTo(Double value) {
            addCriterion("Express_Cost >=", value, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostLessThan(Double value) {
            addCriterion("Express_Cost <", value, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostLessThanOrEqualTo(Double value) {
            addCriterion("Express_Cost <=", value, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostIn(List<Double> values) {
            addCriterion("Express_Cost in", values, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostNotIn(List<Double> values) {
            addCriterion("Express_Cost not in", values, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostBetween(Double value1, Double value2) {
            addCriterion("Express_Cost between", value1, value2, "expressCost");
            return (Criteria) this;
        }

        public Criteria andExpressCostNotBetween(Double value1, Double value2) {
            addCriterion("Express_Cost not between", value1, value2, "expressCost");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("Update_User is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("Update_User is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("Update_User =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("Update_User <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("Update_User >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("Update_User >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("Update_User <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("Update_User <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("Update_User like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("Update_User not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("Update_User in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("Update_User not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("Update_User between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("Update_User not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("Update_Time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("Update_Time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("Update_Time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("Update_Time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("Update_Time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("Update_Time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("Update_Time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("Update_Time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("Update_Time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("Update_Time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("Update_Time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("Update_Time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("Update_Time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("Update_Time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExpressZtIsNull() {
            addCriterion("Express_ZT is null");
            return (Criteria) this;
        }

        public Criteria andExpressZtIsNotNull() {
            addCriterion("Express_ZT is not null");
            return (Criteria) this;
        }

        public Criteria andExpressZtEqualTo(Integer value) {
            addCriterion("Express_ZT =", value, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtNotEqualTo(Integer value) {
            addCriterion("Express_ZT <>", value, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtGreaterThan(Integer value) {
            addCriterion("Express_ZT >", value, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("Express_ZT >=", value, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtLessThan(Integer value) {
            addCriterion("Express_ZT <", value, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtLessThanOrEqualTo(Integer value) {
            addCriterion("Express_ZT <=", value, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtIn(List<Integer> values) {
            addCriterion("Express_ZT in", values, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtNotIn(List<Integer> values) {
            addCriterion("Express_ZT not in", values, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtBetween(Integer value1, Integer value2) {
            addCriterion("Express_ZT between", value1, value2, "expressZt");
            return (Criteria) this;
        }

        public Criteria andExpressZtNotBetween(Integer value1, Integer value2) {
            addCriterion("Express_ZT not between", value1, value2, "expressZt");
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