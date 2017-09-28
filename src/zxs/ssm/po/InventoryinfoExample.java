package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class InventoryinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryinfoExample() {
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

        public Criteria andInventoryremarkIsNull() {
            addCriterion("inventoryRemark is null");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkIsNotNull() {
            addCriterion("inventoryRemark is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkEqualTo(String value) {
            addCriterion("inventoryRemark =", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkNotEqualTo(String value) {
            addCriterion("inventoryRemark <>", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkGreaterThan(String value) {
            addCriterion("inventoryRemark >", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkGreaterThanOrEqualTo(String value) {
            addCriterion("inventoryRemark >=", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkLessThan(String value) {
            addCriterion("inventoryRemark <", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkLessThanOrEqualTo(String value) {
            addCriterion("inventoryRemark <=", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkLike(String value) {
            addCriterion("inventoryRemark like", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkNotLike(String value) {
            addCriterion("inventoryRemark not like", value, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkIn(List<String> values) {
            addCriterion("inventoryRemark in", values, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkNotIn(List<String> values) {
            addCriterion("inventoryRemark not in", values, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkBetween(String value1, String value2) {
            addCriterion("inventoryRemark between", value1, value2, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andInventoryremarkNotBetween(String value1, String value2) {
            addCriterion("inventoryRemark not between", value1, value2, "inventoryremark");
            return (Criteria) this;
        }

        public Criteria andTwIsNull() {
            addCriterion("tw is null");
            return (Criteria) this;
        }

        public Criteria andTwIsNotNull() {
            addCriterion("tw is not null");
            return (Criteria) this;
        }

        public Criteria andTwEqualTo(Integer value) {
            addCriterion("tw =", value, "tw");
            return (Criteria) this;
        }

        public Criteria andTwNotEqualTo(Integer value) {
            addCriterion("tw <>", value, "tw");
            return (Criteria) this;
        }

        public Criteria andTwGreaterThan(Integer value) {
            addCriterion("tw >", value, "tw");
            return (Criteria) this;
        }

        public Criteria andTwGreaterThanOrEqualTo(Integer value) {
            addCriterion("tw >=", value, "tw");
            return (Criteria) this;
        }

        public Criteria andTwLessThan(Integer value) {
            addCriterion("tw <", value, "tw");
            return (Criteria) this;
        }

        public Criteria andTwLessThanOrEqualTo(Integer value) {
            addCriterion("tw <=", value, "tw");
            return (Criteria) this;
        }

        public Criteria andTwIn(List<Integer> values) {
            addCriterion("tw in", values, "tw");
            return (Criteria) this;
        }

        public Criteria andTwNotIn(List<Integer> values) {
            addCriterion("tw not in", values, "tw");
            return (Criteria) this;
        }

        public Criteria andTwBetween(Integer value1, Integer value2) {
            addCriterion("tw between", value1, value2, "tw");
            return (Criteria) this;
        }

        public Criteria andTwNotBetween(Integer value1, Integer value2) {
            addCriterion("tw not between", value1, value2, "tw");
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