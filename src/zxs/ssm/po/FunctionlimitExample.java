package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class FunctionlimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FunctionlimitExample() {
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

        public Criteria andFlIdIsNull() {
            addCriterion("FL_Id is null");
            return (Criteria) this;
        }

        public Criteria andFlIdIsNotNull() {
            addCriterion("FL_Id is not null");
            return (Criteria) this;
        }

        public Criteria andFlIdEqualTo(Integer value) {
            addCriterion("FL_Id =", value, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdNotEqualTo(Integer value) {
            addCriterion("FL_Id <>", value, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdGreaterThan(Integer value) {
            addCriterion("FL_Id >", value, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FL_Id >=", value, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdLessThan(Integer value) {
            addCriterion("FL_Id <", value, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdLessThanOrEqualTo(Integer value) {
            addCriterion("FL_Id <=", value, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdIn(List<Integer> values) {
            addCriterion("FL_Id in", values, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdNotIn(List<Integer> values) {
            addCriterion("FL_Id not in", values, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdBetween(Integer value1, Integer value2) {
            addCriterion("FL_Id between", value1, value2, "flId");
            return (Criteria) this;
        }

        public Criteria andFlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FL_Id not between", value1, value2, "flId");
            return (Criteria) this;
        }

        public Criteria andFlRoleidIsNull() {
            addCriterion("FL_roleid is null");
            return (Criteria) this;
        }

        public Criteria andFlRoleidIsNotNull() {
            addCriterion("FL_roleid is not null");
            return (Criteria) this;
        }

        public Criteria andFlRoleidEqualTo(Integer value) {
            addCriterion("FL_roleid =", value, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidNotEqualTo(Integer value) {
            addCriterion("FL_roleid <>", value, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidGreaterThan(Integer value) {
            addCriterion("FL_roleid >", value, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FL_roleid >=", value, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidLessThan(Integer value) {
            addCriterion("FL_roleid <", value, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("FL_roleid <=", value, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidIn(List<Integer> values) {
            addCriterion("FL_roleid in", values, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidNotIn(List<Integer> values) {
            addCriterion("FL_roleid not in", values, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidBetween(Integer value1, Integer value2) {
            addCriterion("FL_roleid between", value1, value2, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("FL_roleid not between", value1, value2, "flRoleid");
            return (Criteria) this;
        }

        public Criteria andFlFmidIsNull() {
            addCriterion("FL_fmid is null");
            return (Criteria) this;
        }

        public Criteria andFlFmidIsNotNull() {
            addCriterion("FL_fmid is not null");
            return (Criteria) this;
        }

        public Criteria andFlFmidEqualTo(Integer value) {
            addCriterion("FL_fmid =", value, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidNotEqualTo(Integer value) {
            addCriterion("FL_fmid <>", value, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidGreaterThan(Integer value) {
            addCriterion("FL_fmid >", value, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FL_fmid >=", value, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidLessThan(Integer value) {
            addCriterion("FL_fmid <", value, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidLessThanOrEqualTo(Integer value) {
            addCriterion("FL_fmid <=", value, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidIn(List<Integer> values) {
            addCriterion("FL_fmid in", values, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidNotIn(List<Integer> values) {
            addCriterion("FL_fmid not in", values, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidBetween(Integer value1, Integer value2) {
            addCriterion("FL_fmid between", value1, value2, "flFmid");
            return (Criteria) this;
        }

        public Criteria andFlFmidNotBetween(Integer value1, Integer value2) {
            addCriterion("FL_fmid not between", value1, value2, "flFmid");
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