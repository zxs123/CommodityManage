package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailViewExample() {
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

        public Criteria andCommoditymarqueIsNull() {
            addCriterion("commodityMarque is null");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueIsNotNull() {
            addCriterion("commodityMarque is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueEqualTo(String value) {
            addCriterion("commodityMarque =", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueNotEqualTo(String value) {
            addCriterion("commodityMarque <>", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueGreaterThan(String value) {
            addCriterion("commodityMarque >", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueGreaterThanOrEqualTo(String value) {
            addCriterion("commodityMarque >=", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueLessThan(String value) {
            addCriterion("commodityMarque <", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueLessThanOrEqualTo(String value) {
            addCriterion("commodityMarque <=", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueLike(String value) {
            addCriterion("commodityMarque like", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueNotLike(String value) {
            addCriterion("commodityMarque not like", value, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueIn(List<String> values) {
            addCriterion("commodityMarque in", values, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueNotIn(List<String> values) {
            addCriterion("commodityMarque not in", values, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueBetween(String value1, String value2) {
            addCriterion("commodityMarque between", value1, value2, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditymarqueNotBetween(String value1, String value2) {
            addCriterion("commodityMarque not between", value1, value2, "commoditymarque");
            return (Criteria) this;
        }

        public Criteria andCommoditynameIsNull() {
            addCriterion("commodityName is null");
            return (Criteria) this;
        }

        public Criteria andCommoditynameIsNotNull() {
            addCriterion("commodityName is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditynameEqualTo(String value) {
            addCriterion("commodityName =", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotEqualTo(String value) {
            addCriterion("commodityName <>", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameGreaterThan(String value) {
            addCriterion("commodityName >", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameGreaterThanOrEqualTo(String value) {
            addCriterion("commodityName >=", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameLessThan(String value) {
            addCriterion("commodityName <", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameLessThanOrEqualTo(String value) {
            addCriterion("commodityName <=", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameLike(String value) {
            addCriterion("commodityName like", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotLike(String value) {
            addCriterion("commodityName not like", value, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameIn(List<String> values) {
            addCriterion("commodityName in", values, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotIn(List<String> values) {
            addCriterion("commodityName not in", values, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameBetween(String value1, String value2) {
            addCriterion("commodityName between", value1, value2, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommoditynameNotBetween(String value1, String value2) {
            addCriterion("commodityName not between", value1, value2, "commodityname");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleIsNull() {
            addCriterion("commodityScale is null");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleIsNotNull() {
            addCriterion("commodityScale is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleEqualTo(String value) {
            addCriterion("commodityScale =", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleNotEqualTo(String value) {
            addCriterion("commodityScale <>", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleGreaterThan(String value) {
            addCriterion("commodityScale >", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleGreaterThanOrEqualTo(String value) {
            addCriterion("commodityScale >=", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleLessThan(String value) {
            addCriterion("commodityScale <", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleLessThanOrEqualTo(String value) {
            addCriterion("commodityScale <=", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleLike(String value) {
            addCriterion("commodityScale like", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleNotLike(String value) {
            addCriterion("commodityScale not like", value, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleIn(List<String> values) {
            addCriterion("commodityScale in", values, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleNotIn(List<String> values) {
            addCriterion("commodityScale not in", values, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleBetween(String value1, String value2) {
            addCriterion("commodityScale between", value1, value2, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andCommodityscaleNotBetween(String value1, String value2) {
            addCriterion("commodityScale not between", value1, value2, "commodityscale");
            return (Criteria) this;
        }

        public Criteria andInventorynumIsNull() {
            addCriterion("inventoryNum is null");
            return (Criteria) this;
        }

        public Criteria andInventorynumIsNotNull() {
            addCriterion("inventoryNum is not null");
            return (Criteria) this;
        }

        public Criteria andInventorynumEqualTo(Integer value) {
            addCriterion("inventoryNum =", value, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumNotEqualTo(Integer value) {
            addCriterion("inventoryNum <>", value, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumGreaterThan(Integer value) {
            addCriterion("inventoryNum >", value, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventoryNum >=", value, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumLessThan(Integer value) {
            addCriterion("inventoryNum <", value, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumLessThanOrEqualTo(Integer value) {
            addCriterion("inventoryNum <=", value, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumIn(List<Integer> values) {
            addCriterion("inventoryNum in", values, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumNotIn(List<Integer> values) {
            addCriterion("inventoryNum not in", values, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumBetween(Integer value1, Integer value2) {
            addCriterion("inventoryNum between", value1, value2, "inventorynum");
            return (Criteria) this;
        }

        public Criteria andInventorynumNotBetween(Integer value1, Integer value2) {
            addCriterion("inventoryNum not between", value1, value2, "inventorynum");
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