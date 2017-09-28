package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class PhotedetailViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhotedetailViewExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("Photo_Id is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("Photo_Id is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(Integer value) {
            addCriterion("Photo_Id =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(Integer value) {
            addCriterion("Photo_Id <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(Integer value) {
            addCriterion("Photo_Id >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Photo_Id >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(Integer value) {
            addCriterion("Photo_Id <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(Integer value) {
            addCriterion("Photo_Id <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<Integer> values) {
            addCriterion("Photo_Id in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<Integer> values) {
            addCriterion("Photo_Id not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(Integer value1, Integer value2) {
            addCriterion("Photo_Id between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Photo_Id not between", value1, value2, "photoId");
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

        public Criteria andRelationNumIsNull() {
            addCriterion("Relation_Num is null");
            return (Criteria) this;
        }

        public Criteria andRelationNumIsNotNull() {
            addCriterion("Relation_Num is not null");
            return (Criteria) this;
        }

        public Criteria andRelationNumEqualTo(String value) {
            addCriterion("Relation_Num =", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumNotEqualTo(String value) {
            addCriterion("Relation_Num <>", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumGreaterThan(String value) {
            addCriterion("Relation_Num >", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumGreaterThanOrEqualTo(String value) {
            addCriterion("Relation_Num >=", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumLessThan(String value) {
            addCriterion("Relation_Num <", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumLessThanOrEqualTo(String value) {
            addCriterion("Relation_Num <=", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumLike(String value) {
            addCriterion("Relation_Num like", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumNotLike(String value) {
            addCriterion("Relation_Num not like", value, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumIn(List<String> values) {
            addCriterion("Relation_Num in", values, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumNotIn(List<String> values) {
            addCriterion("Relation_Num not in", values, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumBetween(String value1, String value2) {
            addCriterion("Relation_Num between", value1, value2, "relationNum");
            return (Criteria) this;
        }

        public Criteria andRelationNumNotBetween(String value1, String value2) {
            addCriterion("Relation_Num not between", value1, value2, "relationNum");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("Photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("Photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("Photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("Photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("Photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("Photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("Photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("Photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("Photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("Photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("Photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("Photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("Photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("Photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("User_Name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("User_Name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("User_Name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("User_Name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("User_Name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("User_Name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("User_Name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("User_Name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("User_Name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("User_Name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("User_Name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("User_Name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("User_Name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("User_Name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNull() {
            addCriterion("Commit_Time is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("Commit_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(String value) {
            addCriterion("Commit_Time =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(String value) {
            addCriterion("Commit_Time <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(String value) {
            addCriterion("Commit_Time >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(String value) {
            addCriterion("Commit_Time >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(String value) {
            addCriterion("Commit_Time <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(String value) {
            addCriterion("Commit_Time <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLike(String value) {
            addCriterion("Commit_Time like", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotLike(String value) {
            addCriterion("Commit_Time not like", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<String> values) {
            addCriterion("Commit_Time in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<String> values) {
            addCriterion("Commit_Time not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(String value1, String value2) {
            addCriterion("Commit_Time between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(String value1, String value2) {
            addCriterion("Commit_Time not between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeIsNull() {
            addCriterion("Photo_Type is null");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeIsNotNull() {
            addCriterion("Photo_Type is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeEqualTo(String value) {
            addCriterion("Photo_Type =", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotEqualTo(String value) {
            addCriterion("Photo_Type <>", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeGreaterThan(String value) {
            addCriterion("Photo_Type >", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Photo_Type >=", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeLessThan(String value) {
            addCriterion("Photo_Type <", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeLessThanOrEqualTo(String value) {
            addCriterion("Photo_Type <=", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeLike(String value) {
            addCriterion("Photo_Type like", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotLike(String value) {
            addCriterion("Photo_Type not like", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeIn(List<String> values) {
            addCriterion("Photo_Type in", values, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotIn(List<String> values) {
            addCriterion("Photo_Type not in", values, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeBetween(String value1, String value2) {
            addCriterion("Photo_Type between", value1, value2, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotBetween(String value1, String value2) {
            addCriterion("Photo_Type not between", value1, value2, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoBzIsNull() {
            addCriterion("Photo_BZ is null");
            return (Criteria) this;
        }

        public Criteria andPhotoBzIsNotNull() {
            addCriterion("Photo_BZ is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoBzEqualTo(String value) {
            addCriterion("Photo_BZ =", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzNotEqualTo(String value) {
            addCriterion("Photo_BZ <>", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzGreaterThan(String value) {
            addCriterion("Photo_BZ >", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzGreaterThanOrEqualTo(String value) {
            addCriterion("Photo_BZ >=", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzLessThan(String value) {
            addCriterion("Photo_BZ <", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzLessThanOrEqualTo(String value) {
            addCriterion("Photo_BZ <=", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzLike(String value) {
            addCriterion("Photo_BZ like", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzNotLike(String value) {
            addCriterion("Photo_BZ not like", value, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzIn(List<String> values) {
            addCriterion("Photo_BZ in", values, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzNotIn(List<String> values) {
            addCriterion("Photo_BZ not in", values, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzBetween(String value1, String value2) {
            addCriterion("Photo_BZ between", value1, value2, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoBzNotBetween(String value1, String value2) {
            addCriterion("Photo_BZ not between", value1, value2, "photoBz");
            return (Criteria) this;
        }

        public Criteria andPhotoZtIsNull() {
            addCriterion("Photo_ZT is null");
            return (Criteria) this;
        }

        public Criteria andPhotoZtIsNotNull() {
            addCriterion("Photo_ZT is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoZtEqualTo(Integer value) {
            addCriterion("Photo_ZT =", value, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtNotEqualTo(Integer value) {
            addCriterion("Photo_ZT <>", value, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtGreaterThan(Integer value) {
            addCriterion("Photo_ZT >", value, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("Photo_ZT >=", value, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtLessThan(Integer value) {
            addCriterion("Photo_ZT <", value, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtLessThanOrEqualTo(Integer value) {
            addCriterion("Photo_ZT <=", value, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtIn(List<Integer> values) {
            addCriterion("Photo_ZT in", values, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtNotIn(List<Integer> values) {
            addCriterion("Photo_ZT not in", values, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtBetween(Integer value1, Integer value2) {
            addCriterion("Photo_ZT between", value1, value2, "photoZt");
            return (Criteria) this;
        }

        public Criteria andPhotoZtNotBetween(Integer value1, Integer value2) {
            addCriterion("Photo_ZT not between", value1, value2, "photoZt");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("Customer_Name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("Customer_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("Customer_Name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("Customer_Name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("Customer_Name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("Customer_Name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("Customer_Name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("Customer_Name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("Customer_Name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("Customer_Name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("Customer_Name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("Customer_Name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("Customer_Name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("Customer_Name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andTelephone1IsNull() {
            addCriterion("Telephone1 is null");
            return (Criteria) this;
        }

        public Criteria andTelephone1IsNotNull() {
            addCriterion("Telephone1 is not null");
            return (Criteria) this;
        }

        public Criteria andTelephone1EqualTo(String value) {
            addCriterion("Telephone1 =", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotEqualTo(String value) {
            addCriterion("Telephone1 <>", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1GreaterThan(String value) {
            addCriterion("Telephone1 >", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1GreaterThanOrEqualTo(String value) {
            addCriterion("Telephone1 >=", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1LessThan(String value) {
            addCriterion("Telephone1 <", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1LessThanOrEqualTo(String value) {
            addCriterion("Telephone1 <=", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1Like(String value) {
            addCriterion("Telephone1 like", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotLike(String value) {
            addCriterion("Telephone1 not like", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1In(List<String> values) {
            addCriterion("Telephone1 in", values, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotIn(List<String> values) {
            addCriterion("Telephone1 not in", values, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1Between(String value1, String value2) {
            addCriterion("Telephone1 between", value1, value2, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotBetween(String value1, String value2) {
            addCriterion("Telephone1 not between", value1, value2, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone2IsNull() {
            addCriterion("Telephone2 is null");
            return (Criteria) this;
        }

        public Criteria andTelephone2IsNotNull() {
            addCriterion("Telephone2 is not null");
            return (Criteria) this;
        }

        public Criteria andTelephone2EqualTo(String value) {
            addCriterion("Telephone2 =", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotEqualTo(String value) {
            addCriterion("Telephone2 <>", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2GreaterThan(String value) {
            addCriterion("Telephone2 >", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2GreaterThanOrEqualTo(String value) {
            addCriterion("Telephone2 >=", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2LessThan(String value) {
            addCriterion("Telephone2 <", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2LessThanOrEqualTo(String value) {
            addCriterion("Telephone2 <=", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2Like(String value) {
            addCriterion("Telephone2 like", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotLike(String value) {
            addCriterion("Telephone2 not like", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2In(List<String> values) {
            addCriterion("Telephone2 in", values, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotIn(List<String> values) {
            addCriterion("Telephone2 not in", values, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2Between(String value1, String value2) {
            addCriterion("Telephone2 between", value1, value2, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotBetween(String value1, String value2) {
            addCriterion("Telephone2 not between", value1, value2, "telephone2");
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