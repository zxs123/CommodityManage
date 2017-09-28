package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class CommodityinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityinfoExample() {
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

        public Criteria andCommoditytypeIsNull() {
            addCriterion("commodityType is null");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeIsNotNull() {
            addCriterion("commodityType is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeEqualTo(String value) {
            addCriterion("commodityType =", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeNotEqualTo(String value) {
            addCriterion("commodityType <>", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeGreaterThan(String value) {
            addCriterion("commodityType >", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeGreaterThanOrEqualTo(String value) {
            addCriterion("commodityType >=", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeLessThan(String value) {
            addCriterion("commodityType <", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeLessThanOrEqualTo(String value) {
            addCriterion("commodityType <=", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeLike(String value) {
            addCriterion("commodityType like", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeNotLike(String value) {
            addCriterion("commodityType not like", value, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeIn(List<String> values) {
            addCriterion("commodityType in", values, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeNotIn(List<String> values) {
            addCriterion("commodityType not in", values, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeBetween(String value1, String value2) {
            addCriterion("commodityType between", value1, value2, "commoditytype");
            return (Criteria) this;
        }

        public Criteria andCommoditytypeNotBetween(String value1, String value2) {
            addCriterion("commodityType not between", value1, value2, "commoditytype");
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

        public Criteria andCommodityunitIsNull() {
            addCriterion("commodityUnit is null");
            return (Criteria) this;
        }

        public Criteria andCommodityunitIsNotNull() {
            addCriterion("commodityUnit is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityunitEqualTo(String value) {
            addCriterion("commodityUnit =", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitNotEqualTo(String value) {
            addCriterion("commodityUnit <>", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitGreaterThan(String value) {
            addCriterion("commodityUnit >", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitGreaterThanOrEqualTo(String value) {
            addCriterion("commodityUnit >=", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitLessThan(String value) {
            addCriterion("commodityUnit <", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitLessThanOrEqualTo(String value) {
            addCriterion("commodityUnit <=", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitLike(String value) {
            addCriterion("commodityUnit like", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitNotLike(String value) {
            addCriterion("commodityUnit not like", value, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitIn(List<String> values) {
            addCriterion("commodityUnit in", values, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitNotIn(List<String> values) {
            addCriterion("commodityUnit not in", values, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitBetween(String value1, String value2) {
            addCriterion("commodityUnit between", value1, value2, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andCommodityunitNotBetween(String value1, String value2) {
            addCriterion("commodityUnit not between", value1, value2, "commodityunit");
            return (Criteria) this;
        }

        public Criteria andQiyongIsNull() {
            addCriterion("qiyong is null");
            return (Criteria) this;
        }

        public Criteria andQiyongIsNotNull() {
            addCriterion("qiyong is not null");
            return (Criteria) this;
        }

        public Criteria andQiyongEqualTo(Integer value) {
            addCriterion("qiyong =", value, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongNotEqualTo(Integer value) {
            addCriterion("qiyong <>", value, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongGreaterThan(Integer value) {
            addCriterion("qiyong >", value, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongGreaterThanOrEqualTo(Integer value) {
            addCriterion("qiyong >=", value, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongLessThan(Integer value) {
            addCriterion("qiyong <", value, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongLessThanOrEqualTo(Integer value) {
            addCriterion("qiyong <=", value, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongIn(List<Integer> values) {
            addCriterion("qiyong in", values, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongNotIn(List<Integer> values) {
            addCriterion("qiyong not in", values, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongBetween(Integer value1, Integer value2) {
            addCriterion("qiyong between", value1, value2, "qiyong");
            return (Criteria) this;
        }

        public Criteria andQiyongNotBetween(Integer value1, Integer value2) {
            addCriterion("qiyong not between", value1, value2, "qiyong");
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