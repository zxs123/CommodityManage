package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailExample() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("Detail_Id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("Detail_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Integer value) {
            addCriterion("Detail_Id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Integer value) {
            addCriterion("Detail_Id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Integer value) {
            addCriterion("Detail_Id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Detail_Id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Integer value) {
            addCriterion("Detail_Id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("Detail_Id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Integer> values) {
            addCriterion("Detail_Id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Integer> values) {
            addCriterion("Detail_Id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("Detail_Id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Detail_Id not between", value1, value2, "detailId");
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

        public Criteria andCommodityMarqueIsNull() {
            addCriterion("Commodity_Marque is null");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueIsNotNull() {
            addCriterion("Commodity_Marque is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueEqualTo(String value) {
            addCriterion("Commodity_Marque =", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueNotEqualTo(String value) {
            addCriterion("Commodity_Marque <>", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueGreaterThan(String value) {
            addCriterion("Commodity_Marque >", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueGreaterThanOrEqualTo(String value) {
            addCriterion("Commodity_Marque >=", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueLessThan(String value) {
            addCriterion("Commodity_Marque <", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueLessThanOrEqualTo(String value) {
            addCriterion("Commodity_Marque <=", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueLike(String value) {
            addCriterion("Commodity_Marque like", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueNotLike(String value) {
            addCriterion("Commodity_Marque not like", value, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueIn(List<String> values) {
            addCriterion("Commodity_Marque in", values, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueNotIn(List<String> values) {
            addCriterion("Commodity_Marque not in", values, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueBetween(String value1, String value2) {
            addCriterion("Commodity_Marque between", value1, value2, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityMarqueNotBetween(String value1, String value2) {
            addCriterion("Commodity_Marque not between", value1, value2, "commodityMarque");
            return (Criteria) this;
        }

        public Criteria andCommodityNumIsNull() {
            addCriterion("Commodity_Num is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumIsNotNull() {
            addCriterion("Commodity_Num is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumEqualTo(Integer value) {
            addCriterion("Commodity_Num =", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumNotEqualTo(Integer value) {
            addCriterion("Commodity_Num <>", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumGreaterThan(Integer value) {
            addCriterion("Commodity_Num >", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Commodity_Num >=", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumLessThan(Integer value) {
            addCriterion("Commodity_Num <", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumLessThanOrEqualTo(Integer value) {
            addCriterion("Commodity_Num <=", value, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumIn(List<Integer> values) {
            addCriterion("Commodity_Num in", values, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumNotIn(List<Integer> values) {
            addCriterion("Commodity_Num not in", values, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumBetween(Integer value1, Integer value2) {
            addCriterion("Commodity_Num between", value1, value2, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andCommodityNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Commodity_Num not between", value1, value2, "commodityNum");
            return (Criteria) this;
        }

        public Criteria andDetailZtIsNull() {
            addCriterion("Detail_ZT is null");
            return (Criteria) this;
        }

        public Criteria andDetailZtIsNotNull() {
            addCriterion("Detail_ZT is not null");
            return (Criteria) this;
        }

        public Criteria andDetailZtEqualTo(Integer value) {
            addCriterion("Detail_ZT =", value, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtNotEqualTo(Integer value) {
            addCriterion("Detail_ZT <>", value, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtGreaterThan(Integer value) {
            addCriterion("Detail_ZT >", value, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("Detail_ZT >=", value, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtLessThan(Integer value) {
            addCriterion("Detail_ZT <", value, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtLessThanOrEqualTo(Integer value) {
            addCriterion("Detail_ZT <=", value, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtIn(List<Integer> values) {
            addCriterion("Detail_ZT in", values, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtNotIn(List<Integer> values) {
            addCriterion("Detail_ZT not in", values, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtBetween(Integer value1, Integer value2) {
            addCriterion("Detail_ZT between", value1, value2, "detailZt");
            return (Criteria) this;
        }

        public Criteria andDetailZtNotBetween(Integer value1, Integer value2) {
            addCriterion("Detail_ZT not between", value1, value2, "detailZt");
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