package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class AlterinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlterinfoExample() {
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

        public Criteria andAlteridIsNull() {
            addCriterion("alterId is null");
            return (Criteria) this;
        }

        public Criteria andAlteridIsNotNull() {
            addCriterion("alterId is not null");
            return (Criteria) this;
        }

        public Criteria andAlteridEqualTo(Integer value) {
            addCriterion("alterId =", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridNotEqualTo(Integer value) {
            addCriterion("alterId <>", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridGreaterThan(Integer value) {
            addCriterion("alterId >", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("alterId >=", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridLessThan(Integer value) {
            addCriterion("alterId <", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridLessThanOrEqualTo(Integer value) {
            addCriterion("alterId <=", value, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridIn(List<Integer> values) {
            addCriterion("alterId in", values, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridNotIn(List<Integer> values) {
            addCriterion("alterId not in", values, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridBetween(Integer value1, Integer value2) {
            addCriterion("alterId between", value1, value2, "alterid");
            return (Criteria) this;
        }

        public Criteria andAlteridNotBetween(Integer value1, Integer value2) {
            addCriterion("alterId not between", value1, value2, "alterid");
            return (Criteria) this;
        }

        public Criteria andCommodityidIsNull() {
            addCriterion("commodityId is null");
            return (Criteria) this;
        }

        public Criteria andCommodityidIsNotNull() {
            addCriterion("commodityId is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityidEqualTo(Integer value) {
            addCriterion("commodityId =", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotEqualTo(Integer value) {
            addCriterion("commodityId <>", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidGreaterThan(Integer value) {
            addCriterion("commodityId >", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodityId >=", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidLessThan(Integer value) {
            addCriterion("commodityId <", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidLessThanOrEqualTo(Integer value) {
            addCriterion("commodityId <=", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidIn(List<Integer> values) {
            addCriterion("commodityId in", values, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotIn(List<Integer> values) {
            addCriterion("commodityId not in", values, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidBetween(Integer value1, Integer value2) {
            addCriterion("commodityId between", value1, value2, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotBetween(Integer value1, Integer value2) {
            addCriterion("commodityId not between", value1, value2, "commodityid");
            return (Criteria) this;
        }

        public Criteria andAltertimeIsNull() {
            addCriterion("alterTime is null");
            return (Criteria) this;
        }

        public Criteria andAltertimeIsNotNull() {
            addCriterion("alterTime is not null");
            return (Criteria) this;
        }

        public Criteria andAltertimeEqualTo(String value) {
            addCriterion("alterTime =", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeNotEqualTo(String value) {
            addCriterion("alterTime <>", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeGreaterThan(String value) {
            addCriterion("alterTime >", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeGreaterThanOrEqualTo(String value) {
            addCriterion("alterTime >=", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeLessThan(String value) {
            addCriterion("alterTime <", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeLessThanOrEqualTo(String value) {
            addCriterion("alterTime <=", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeLike(String value) {
            addCriterion("alterTime like", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeNotLike(String value) {
            addCriterion("alterTime not like", value, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeIn(List<String> values) {
            addCriterion("alterTime in", values, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeNotIn(List<String> values) {
            addCriterion("alterTime not in", values, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeBetween(String value1, String value2) {
            addCriterion("alterTime between", value1, value2, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertimeNotBetween(String value1, String value2) {
            addCriterion("alterTime not between", value1, value2, "altertime");
            return (Criteria) this;
        }

        public Criteria andAltertypeIsNull() {
            addCriterion("alterType is null");
            return (Criteria) this;
        }

        public Criteria andAltertypeIsNotNull() {
            addCriterion("alterType is not null");
            return (Criteria) this;
        }

        public Criteria andAltertypeEqualTo(String value) {
            addCriterion("alterType =", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeNotEqualTo(String value) {
            addCriterion("alterType <>", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeGreaterThan(String value) {
            addCriterion("alterType >", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeGreaterThanOrEqualTo(String value) {
            addCriterion("alterType >=", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeLessThan(String value) {
            addCriterion("alterType <", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeLessThanOrEqualTo(String value) {
            addCriterion("alterType <=", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeLike(String value) {
            addCriterion("alterType like", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeNotLike(String value) {
            addCriterion("alterType not like", value, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeIn(List<String> values) {
            addCriterion("alterType in", values, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeNotIn(List<String> values) {
            addCriterion("alterType not in", values, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeBetween(String value1, String value2) {
            addCriterion("alterType between", value1, value2, "altertype");
            return (Criteria) this;
        }

        public Criteria andAltertypeNotBetween(String value1, String value2) {
            addCriterion("alterType not between", value1, value2, "altertype");
            return (Criteria) this;
        }

        public Criteria andAlternumIsNull() {
            addCriterion("alterNum is null");
            return (Criteria) this;
        }

        public Criteria andAlternumIsNotNull() {
            addCriterion("alterNum is not null");
            return (Criteria) this;
        }

        public Criteria andAlternumEqualTo(Integer value) {
            addCriterion("alterNum =", value, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumNotEqualTo(Integer value) {
            addCriterion("alterNum <>", value, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumGreaterThan(Integer value) {
            addCriterion("alterNum >", value, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumGreaterThanOrEqualTo(Integer value) {
            addCriterion("alterNum >=", value, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumLessThan(Integer value) {
            addCriterion("alterNum <", value, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumLessThanOrEqualTo(Integer value) {
            addCriterion("alterNum <=", value, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumIn(List<Integer> values) {
            addCriterion("alterNum in", values, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumNotIn(List<Integer> values) {
            addCriterion("alterNum not in", values, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumBetween(Integer value1, Integer value2) {
            addCriterion("alterNum between", value1, value2, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlternumNotBetween(Integer value1, Integer value2) {
            addCriterion("alterNum not between", value1, value2, "alternum");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryIsNull() {
            addCriterion("alterInventory is null");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryIsNotNull() {
            addCriterion("alterInventory is not null");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryEqualTo(Integer value) {
            addCriterion("alterInventory =", value, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryNotEqualTo(Integer value) {
            addCriterion("alterInventory <>", value, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryGreaterThan(Integer value) {
            addCriterion("alterInventory >", value, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("alterInventory >=", value, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryLessThan(Integer value) {
            addCriterion("alterInventory <", value, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryLessThanOrEqualTo(Integer value) {
            addCriterion("alterInventory <=", value, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryIn(List<Integer> values) {
            addCriterion("alterInventory in", values, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryNotIn(List<Integer> values) {
            addCriterion("alterInventory not in", values, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryBetween(Integer value1, Integer value2) {
            addCriterion("alterInventory between", value1, value2, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andAlterinventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("alterInventory not between", value1, value2, "alterinventory");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
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

        public Criteria andAlterremarkIsNull() {
            addCriterion("alterRemark is null");
            return (Criteria) this;
        }

        public Criteria andAlterremarkIsNotNull() {
            addCriterion("alterRemark is not null");
            return (Criteria) this;
        }

        public Criteria andAlterremarkEqualTo(String value) {
            addCriterion("alterRemark =", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkNotEqualTo(String value) {
            addCriterion("alterRemark <>", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkGreaterThan(String value) {
            addCriterion("alterRemark >", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkGreaterThanOrEqualTo(String value) {
            addCriterion("alterRemark >=", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkLessThan(String value) {
            addCriterion("alterRemark <", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkLessThanOrEqualTo(String value) {
            addCriterion("alterRemark <=", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkLike(String value) {
            addCriterion("alterRemark like", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkNotLike(String value) {
            addCriterion("alterRemark not like", value, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkIn(List<String> values) {
            addCriterion("alterRemark in", values, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkNotIn(List<String> values) {
            addCriterion("alterRemark not in", values, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkBetween(String value1, String value2) {
            addCriterion("alterRemark between", value1, value2, "alterremark");
            return (Criteria) this;
        }

        public Criteria andAlterremarkNotBetween(String value1, String value2) {
            addCriterion("alterRemark not between", value1, value2, "alterremark");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("zt is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("zt is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(Integer value) {
            addCriterion("zt =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(Integer value) {
            addCriterion("zt <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(Integer value) {
            addCriterion("zt >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("zt >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(Integer value) {
            addCriterion("zt <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(Integer value) {
            addCriterion("zt <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<Integer> values) {
            addCriterion("zt in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<Integer> values) {
            addCriterion("zt not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(Integer value1, Integer value2) {
            addCriterion("zt between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(Integer value1, Integer value2) {
            addCriterion("zt not between", value1, value2, "zt");
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