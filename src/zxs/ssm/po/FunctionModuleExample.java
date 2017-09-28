package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class FunctionModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FunctionModuleExample() {
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

        public Criteria andFmIdIsNull() {
            addCriterion("FM_Id is null");
            return (Criteria) this;
        }

        public Criteria andFmIdIsNotNull() {
            addCriterion("FM_Id is not null");
            return (Criteria) this;
        }

        public Criteria andFmIdEqualTo(Integer value) {
            addCriterion("FM_Id =", value, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdNotEqualTo(Integer value) {
            addCriterion("FM_Id <>", value, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdGreaterThan(Integer value) {
            addCriterion("FM_Id >", value, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FM_Id >=", value, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdLessThan(Integer value) {
            addCriterion("FM_Id <", value, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdLessThanOrEqualTo(Integer value) {
            addCriterion("FM_Id <=", value, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdIn(List<Integer> values) {
            addCriterion("FM_Id in", values, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdNotIn(List<Integer> values) {
            addCriterion("FM_Id not in", values, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdBetween(Integer value1, Integer value2) {
            addCriterion("FM_Id between", value1, value2, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FM_Id not between", value1, value2, "fmId");
            return (Criteria) this;
        }

        public Criteria andFmNameIsNull() {
            addCriterion("FM_name is null");
            return (Criteria) this;
        }

        public Criteria andFmNameIsNotNull() {
            addCriterion("FM_name is not null");
            return (Criteria) this;
        }

        public Criteria andFmNameEqualTo(String value) {
            addCriterion("FM_name =", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameNotEqualTo(String value) {
            addCriterion("FM_name <>", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameGreaterThan(String value) {
            addCriterion("FM_name >", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameGreaterThanOrEqualTo(String value) {
            addCriterion("FM_name >=", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameLessThan(String value) {
            addCriterion("FM_name <", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameLessThanOrEqualTo(String value) {
            addCriterion("FM_name <=", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameLike(String value) {
            addCriterion("FM_name like", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameNotLike(String value) {
            addCriterion("FM_name not like", value, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameIn(List<String> values) {
            addCriterion("FM_name in", values, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameNotIn(List<String> values) {
            addCriterion("FM_name not in", values, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameBetween(String value1, String value2) {
            addCriterion("FM_name between", value1, value2, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmNameNotBetween(String value1, String value2) {
            addCriterion("FM_name not between", value1, value2, "fmName");
            return (Criteria) this;
        }

        public Criteria andFmActionIsNull() {
            addCriterion("FM_action is null");
            return (Criteria) this;
        }

        public Criteria andFmActionIsNotNull() {
            addCriterion("FM_action is not null");
            return (Criteria) this;
        }

        public Criteria andFmActionEqualTo(String value) {
            addCriterion("FM_action =", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionNotEqualTo(String value) {
            addCriterion("FM_action <>", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionGreaterThan(String value) {
            addCriterion("FM_action >", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionGreaterThanOrEqualTo(String value) {
            addCriterion("FM_action >=", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionLessThan(String value) {
            addCriterion("FM_action <", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionLessThanOrEqualTo(String value) {
            addCriterion("FM_action <=", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionLike(String value) {
            addCriterion("FM_action like", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionNotLike(String value) {
            addCriterion("FM_action not like", value, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionIn(List<String> values) {
            addCriterion("FM_action in", values, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionNotIn(List<String> values) {
            addCriterion("FM_action not in", values, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionBetween(String value1, String value2) {
            addCriterion("FM_action between", value1, value2, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmActionNotBetween(String value1, String value2) {
            addCriterion("FM_action not between", value1, value2, "fmAction");
            return (Criteria) this;
        }

        public Criteria andFmCategoryIsNull() {
            addCriterion("FM_category is null");
            return (Criteria) this;
        }

        public Criteria andFmCategoryIsNotNull() {
            addCriterion("FM_category is not null");
            return (Criteria) this;
        }

        public Criteria andFmCategoryEqualTo(Integer value) {
            addCriterion("FM_category =", value, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryNotEqualTo(Integer value) {
            addCriterion("FM_category <>", value, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryGreaterThan(Integer value) {
            addCriterion("FM_category >", value, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("FM_category >=", value, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryLessThan(Integer value) {
            addCriterion("FM_category <", value, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("FM_category <=", value, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryIn(List<Integer> values) {
            addCriterion("FM_category in", values, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryNotIn(List<Integer> values) {
            addCriterion("FM_category not in", values, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryBetween(Integer value1, Integer value2) {
            addCriterion("FM_category between", value1, value2, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("FM_category not between", value1, value2, "fmCategory");
            return (Criteria) this;
        }

        public Criteria andFmCatenameIsNull() {
            addCriterion("FM_catename is null");
            return (Criteria) this;
        }

        public Criteria andFmCatenameIsNotNull() {
            addCriterion("FM_catename is not null");
            return (Criteria) this;
        }

        public Criteria andFmCatenameEqualTo(String value) {
            addCriterion("FM_catename =", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameNotEqualTo(String value) {
            addCriterion("FM_catename <>", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameGreaterThan(String value) {
            addCriterion("FM_catename >", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameGreaterThanOrEqualTo(String value) {
            addCriterion("FM_catename >=", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameLessThan(String value) {
            addCriterion("FM_catename <", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameLessThanOrEqualTo(String value) {
            addCriterion("FM_catename <=", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameLike(String value) {
            addCriterion("FM_catename like", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameNotLike(String value) {
            addCriterion("FM_catename not like", value, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameIn(List<String> values) {
            addCriterion("FM_catename in", values, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameNotIn(List<String> values) {
            addCriterion("FM_catename not in", values, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameBetween(String value1, String value2) {
            addCriterion("FM_catename between", value1, value2, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmCatenameNotBetween(String value1, String value2) {
            addCriterion("FM_catename not between", value1, value2, "fmCatename");
            return (Criteria) this;
        }

        public Criteria andFmRemarkIsNull() {
            addCriterion("FM_remark is null");
            return (Criteria) this;
        }

        public Criteria andFmRemarkIsNotNull() {
            addCriterion("FM_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFmRemarkEqualTo(String value) {
            addCriterion("FM_remark =", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkNotEqualTo(String value) {
            addCriterion("FM_remark <>", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkGreaterThan(String value) {
            addCriterion("FM_remark >", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("FM_remark >=", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkLessThan(String value) {
            addCriterion("FM_remark <", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkLessThanOrEqualTo(String value) {
            addCriterion("FM_remark <=", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkLike(String value) {
            addCriterion("FM_remark like", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkNotLike(String value) {
            addCriterion("FM_remark not like", value, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkIn(List<String> values) {
            addCriterion("FM_remark in", values, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkNotIn(List<String> values) {
            addCriterion("FM_remark not in", values, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkBetween(String value1, String value2) {
            addCriterion("FM_remark between", value1, value2, "fmRemark");
            return (Criteria) this;
        }

        public Criteria andFmRemarkNotBetween(String value1, String value2) {
            addCriterion("FM_remark not between", value1, value2, "fmRemark");
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