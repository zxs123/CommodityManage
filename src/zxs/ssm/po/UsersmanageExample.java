package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class UsersmanageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersmanageExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("User_Id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("User_Id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("User_Id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("User_Id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("User_Id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("User_Id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("User_Id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("User_Id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("User_Id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("User_Id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("User_Id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("User_Id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("User_Id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("User_Id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("User_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("User_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("User_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("User_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("User_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("User_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("User_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("User_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("User_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("User_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("User_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("User_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("User_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("User_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneIsNull() {
            addCriterion("User_cellphone is null");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneIsNotNull() {
            addCriterion("User_cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneEqualTo(String value) {
            addCriterion("User_cellphone =", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneNotEqualTo(String value) {
            addCriterion("User_cellphone <>", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneGreaterThan(String value) {
            addCriterion("User_cellphone >", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("User_cellphone >=", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneLessThan(String value) {
            addCriterion("User_cellphone <", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneLessThanOrEqualTo(String value) {
            addCriterion("User_cellphone <=", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneLike(String value) {
            addCriterion("User_cellphone like", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneNotLike(String value) {
            addCriterion("User_cellphone not like", value, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneIn(List<String> values) {
            addCriterion("User_cellphone in", values, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneNotIn(List<String> values) {
            addCriterion("User_cellphone not in", values, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneBetween(String value1, String value2) {
            addCriterion("User_cellphone between", value1, value2, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserCellphoneNotBetween(String value1, String value2) {
            addCriterion("User_cellphone not between", value1, value2, "userCellphone");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNull() {
            addCriterion("User_tel is null");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNotNull() {
            addCriterion("User_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelEqualTo(String value) {
            addCriterion("User_tel =", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotEqualTo(String value) {
            addCriterion("User_tel <>", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThan(String value) {
            addCriterion("User_tel >", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("User_tel >=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThan(String value) {
            addCriterion("User_tel <", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThanOrEqualTo(String value) {
            addCriterion("User_tel <=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLike(String value) {
            addCriterion("User_tel like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotLike(String value) {
            addCriterion("User_tel not like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelIn(List<String> values) {
            addCriterion("User_tel in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotIn(List<String> values) {
            addCriterion("User_tel not in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelBetween(String value1, String value2) {
            addCriterion("User_tel between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotBetween(String value1, String value2) {
            addCriterion("User_tel not between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("User_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("User_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("User_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("User_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("User_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("User_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("User_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("User_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("User_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("User_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("User_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("User_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("User_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("User_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andSrNameIsNull() {
            addCriterion("SR_name is null");
            return (Criteria) this;
        }

        public Criteria andSrNameIsNotNull() {
            addCriterion("SR_name is not null");
            return (Criteria) this;
        }

        public Criteria andSrNameEqualTo(String value) {
            addCriterion("SR_name =", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotEqualTo(String value) {
            addCriterion("SR_name <>", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameGreaterThan(String value) {
            addCriterion("SR_name >", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameGreaterThanOrEqualTo(String value) {
            addCriterion("SR_name >=", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLessThan(String value) {
            addCriterion("SR_name <", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLessThanOrEqualTo(String value) {
            addCriterion("SR_name <=", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLike(String value) {
            addCriterion("SR_name like", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotLike(String value) {
            addCriterion("SR_name not like", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameIn(List<String> values) {
            addCriterion("SR_name in", values, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotIn(List<String> values) {
            addCriterion("SR_name not in", values, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameBetween(String value1, String value2) {
            addCriterion("SR_name between", value1, value2, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotBetween(String value1, String value2) {
            addCriterion("SR_name not between", value1, value2, "srName");
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

        public Criteria andUserRnameIsNull() {
            addCriterion("User_rname is null");
            return (Criteria) this;
        }

        public Criteria andUserRnameIsNotNull() {
            addCriterion("User_rname is not null");
            return (Criteria) this;
        }

        public Criteria andUserRnameEqualTo(String value) {
            addCriterion("User_rname =", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameNotEqualTo(String value) {
            addCriterion("User_rname <>", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameGreaterThan(String value) {
            addCriterion("User_rname >", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameGreaterThanOrEqualTo(String value) {
            addCriterion("User_rname >=", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameLessThan(String value) {
            addCriterion("User_rname <", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameLessThanOrEqualTo(String value) {
            addCriterion("User_rname <=", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameLike(String value) {
            addCriterion("User_rname like", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameNotLike(String value) {
            addCriterion("User_rname not like", value, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameIn(List<String> values) {
            addCriterion("User_rname in", values, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameNotIn(List<String> values) {
            addCriterion("User_rname not in", values, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameBetween(String value1, String value2) {
            addCriterion("User_rname between", value1, value2, "userRname");
            return (Criteria) this;
        }

        public Criteria andUserRnameNotBetween(String value1, String value2) {
            addCriterion("User_rname not between", value1, value2, "userRname");
            return (Criteria) this;
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

        public Criteria andSrReidIsNull() {
            addCriterion("SR_reid is null");
            return (Criteria) this;
        }

        public Criteria andSrReidIsNotNull() {
            addCriterion("SR_reid is not null");
            return (Criteria) this;
        }

        public Criteria andSrReidEqualTo(String value) {
            addCriterion("SR_reid =", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidNotEqualTo(String value) {
            addCriterion("SR_reid <>", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidGreaterThan(String value) {
            addCriterion("SR_reid >", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidGreaterThanOrEqualTo(String value) {
            addCriterion("SR_reid >=", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidLessThan(String value) {
            addCriterion("SR_reid <", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidLessThanOrEqualTo(String value) {
            addCriterion("SR_reid <=", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidLike(String value) {
            addCriterion("SR_reid like", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidNotLike(String value) {
            addCriterion("SR_reid not like", value, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidIn(List<String> values) {
            addCriterion("SR_reid in", values, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidNotIn(List<String> values) {
            addCriterion("SR_reid not in", values, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidBetween(String value1, String value2) {
            addCriterion("SR_reid between", value1, value2, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrReidNotBetween(String value1, String value2) {
            addCriterion("SR_reid not between", value1, value2, "srReid");
            return (Criteria) this;
        }

        public Criteria andSrIdIsNull() {
            addCriterion("SR_Id is null");
            return (Criteria) this;
        }

        public Criteria andSrIdIsNotNull() {
            addCriterion("SR_Id is not null");
            return (Criteria) this;
        }

        public Criteria andSrIdEqualTo(Integer value) {
            addCriterion("SR_Id =", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdNotEqualTo(Integer value) {
            addCriterion("SR_Id <>", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdGreaterThan(Integer value) {
            addCriterion("SR_Id >", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SR_Id >=", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdLessThan(Integer value) {
            addCriterion("SR_Id <", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdLessThanOrEqualTo(Integer value) {
            addCriterion("SR_Id <=", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdIn(List<Integer> values) {
            addCriterion("SR_Id in", values, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdNotIn(List<Integer> values) {
            addCriterion("SR_Id not in", values, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdBetween(Integer value1, Integer value2) {
            addCriterion("SR_Id between", value1, value2, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SR_Id not between", value1, value2, "srId");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("User_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("User_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("User_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("User_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("User_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("User_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("User_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("User_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("User_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("User_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("User_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("User_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("User_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("User_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserIdcardIsNull() {
            addCriterion("User_idcard is null");
            return (Criteria) this;
        }

        public Criteria andUserIdcardIsNotNull() {
            addCriterion("User_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdcardEqualTo(String value) {
            addCriterion("User_idcard =", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNotEqualTo(String value) {
            addCriterion("User_idcard <>", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardGreaterThan(String value) {
            addCriterion("User_idcard >", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("User_idcard >=", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardLessThan(String value) {
            addCriterion("User_idcard <", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardLessThanOrEqualTo(String value) {
            addCriterion("User_idcard <=", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardLike(String value) {
            addCriterion("User_idcard like", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNotLike(String value) {
            addCriterion("User_idcard not like", value, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardIn(List<String> values) {
            addCriterion("User_idcard in", values, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNotIn(List<String> values) {
            addCriterion("User_idcard not in", values, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardBetween(String value1, String value2) {
            addCriterion("User_idcard between", value1, value2, "userIdcard");
            return (Criteria) this;
        }

        public Criteria andUserIdcardNotBetween(String value1, String value2) {
            addCriterion("User_idcard not between", value1, value2, "userIdcard");
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