package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentExample() {
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

        public Criteria andDepIdIsNull() {
            addCriterion("Dep_Id is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("Dep_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(String value) {
            addCriterion("Dep_Id =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(String value) {
            addCriterion("Dep_Id <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(String value) {
            addCriterion("Dep_Id >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(String value) {
            addCriterion("Dep_Id >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(String value) {
            addCriterion("Dep_Id <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(String value) {
            addCriterion("Dep_Id <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLike(String value) {
            addCriterion("Dep_Id like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotLike(String value) {
            addCriterion("Dep_Id not like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<String> values) {
            addCriterion("Dep_Id in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<String> values) {
            addCriterion("Dep_Id not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(String value1, String value2) {
            addCriterion("Dep_Id between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(String value1, String value2) {
            addCriterion("Dep_Id not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("Dep_name is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("Dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("Dep_name =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("Dep_name <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("Dep_name >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("Dep_name >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("Dep_name <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("Dep_name <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("Dep_name like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("Dep_name not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("Dep_name in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("Dep_name not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("Dep_name between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("Dep_name not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepSortIsNull() {
            addCriterion("Dep_sort is null");
            return (Criteria) this;
        }

        public Criteria andDepSortIsNotNull() {
            addCriterion("Dep_sort is not null");
            return (Criteria) this;
        }

        public Criteria andDepSortEqualTo(Integer value) {
            addCriterion("Dep_sort =", value, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortNotEqualTo(Integer value) {
            addCriterion("Dep_sort <>", value, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortGreaterThan(Integer value) {
            addCriterion("Dep_sort >", value, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dep_sort >=", value, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortLessThan(Integer value) {
            addCriterion("Dep_sort <", value, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortLessThanOrEqualTo(Integer value) {
            addCriterion("Dep_sort <=", value, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortIn(List<Integer> values) {
            addCriterion("Dep_sort in", values, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortNotIn(List<Integer> values) {
            addCriterion("Dep_sort not in", values, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortBetween(Integer value1, Integer value2) {
            addCriterion("Dep_sort between", value1, value2, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepSortNotBetween(Integer value1, Integer value2) {
            addCriterion("Dep_sort not between", value1, value2, "depSort");
            return (Criteria) this;
        }

        public Criteria andDepRemarkIsNull() {
            addCriterion("Dep_remark is null");
            return (Criteria) this;
        }

        public Criteria andDepRemarkIsNotNull() {
            addCriterion("Dep_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDepRemarkEqualTo(String value) {
            addCriterion("Dep_remark =", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotEqualTo(String value) {
            addCriterion("Dep_remark <>", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkGreaterThan(String value) {
            addCriterion("Dep_remark >", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Dep_remark >=", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkLessThan(String value) {
            addCriterion("Dep_remark <", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkLessThanOrEqualTo(String value) {
            addCriterion("Dep_remark <=", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkLike(String value) {
            addCriterion("Dep_remark like", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotLike(String value) {
            addCriterion("Dep_remark not like", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkIn(List<String> values) {
            addCriterion("Dep_remark in", values, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotIn(List<String> values) {
            addCriterion("Dep_remark not in", values, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkBetween(String value1, String value2) {
            addCriterion("Dep_remark between", value1, value2, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotBetween(String value1, String value2) {
            addCriterion("Dep_remark not between", value1, value2, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepQueueIsNull() {
            addCriterion("Dep_queue is null");
            return (Criteria) this;
        }

        public Criteria andDepQueueIsNotNull() {
            addCriterion("Dep_queue is not null");
            return (Criteria) this;
        }

        public Criteria andDepQueueEqualTo(Integer value) {
            addCriterion("Dep_queue =", value, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueNotEqualTo(Integer value) {
            addCriterion("Dep_queue <>", value, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueGreaterThan(Integer value) {
            addCriterion("Dep_queue >", value, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dep_queue >=", value, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueLessThan(Integer value) {
            addCriterion("Dep_queue <", value, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueLessThanOrEqualTo(Integer value) {
            addCriterion("Dep_queue <=", value, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueIn(List<Integer> values) {
            addCriterion("Dep_queue in", values, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueNotIn(List<Integer> values) {
            addCriterion("Dep_queue not in", values, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueBetween(Integer value1, Integer value2) {
            addCriterion("Dep_queue between", value1, value2, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepQueueNotBetween(Integer value1, Integer value2) {
            addCriterion("Dep_queue not between", value1, value2, "depQueue");
            return (Criteria) this;
        }

        public Criteria andDepAssessIsNull() {
            addCriterion("Dep_assess is null");
            return (Criteria) this;
        }

        public Criteria andDepAssessIsNotNull() {
            addCriterion("Dep_assess is not null");
            return (Criteria) this;
        }

        public Criteria andDepAssessEqualTo(Integer value) {
            addCriterion("Dep_assess =", value, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessNotEqualTo(Integer value) {
            addCriterion("Dep_assess <>", value, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessGreaterThan(Integer value) {
            addCriterion("Dep_assess >", value, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dep_assess >=", value, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessLessThan(Integer value) {
            addCriterion("Dep_assess <", value, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessLessThanOrEqualTo(Integer value) {
            addCriterion("Dep_assess <=", value, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessIn(List<Integer> values) {
            addCriterion("Dep_assess in", values, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessNotIn(List<Integer> values) {
            addCriterion("Dep_assess not in", values, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessBetween(Integer value1, Integer value2) {
            addCriterion("Dep_assess between", value1, value2, "depAssess");
            return (Criteria) this;
        }

        public Criteria andDepAssessNotBetween(Integer value1, Integer value2) {
            addCriterion("Dep_assess not between", value1, value2, "depAssess");
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