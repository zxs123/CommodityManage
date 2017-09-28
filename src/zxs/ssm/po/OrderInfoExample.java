package zxs.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("Create_Time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("Create_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("Create_Time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("Create_Time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("Create_Time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("Create_Time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("Create_Time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("Create_Time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("Create_Time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("Create_Time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("Create_Time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("Create_Time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("Create_Time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("Create_Time not between", value1, value2, "createTime");
            return (Criteria) this;
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

        public Criteria andSendTimeIsNull() {
            addCriterion("Send_Time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("Send_Time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(String value) {
            addCriterion("Send_Time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(String value) {
            addCriterion("Send_Time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(String value) {
            addCriterion("Send_Time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("Send_Time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(String value) {
            addCriterion("Send_Time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(String value) {
            addCriterion("Send_Time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLike(String value) {
            addCriterion("Send_Time like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotLike(String value) {
            addCriterion("Send_Time not like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<String> values) {
            addCriterion("Send_Time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<String> values) {
            addCriterion("Send_Time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(String value1, String value2) {
            addCriterion("Send_Time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(String value1, String value2) {
            addCriterion("Send_Time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andIsSentIsNull() {
            addCriterion("Is_Sent is null");
            return (Criteria) this;
        }

        public Criteria andIsSentIsNotNull() {
            addCriterion("Is_Sent is not null");
            return (Criteria) this;
        }

        public Criteria andIsSentEqualTo(Integer value) {
            addCriterion("Is_Sent =", value, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentNotEqualTo(Integer value) {
            addCriterion("Is_Sent <>", value, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentGreaterThan(Integer value) {
            addCriterion("Is_Sent >", value, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentGreaterThanOrEqualTo(Integer value) {
            addCriterion("Is_Sent >=", value, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentLessThan(Integer value) {
            addCriterion("Is_Sent <", value, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentLessThanOrEqualTo(Integer value) {
            addCriterion("Is_Sent <=", value, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentIn(List<Integer> values) {
            addCriterion("Is_Sent in", values, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentNotIn(List<Integer> values) {
            addCriterion("Is_Sent not in", values, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentBetween(Integer value1, Integer value2) {
            addCriterion("Is_Sent between", value1, value2, "isSent");
            return (Criteria) this;
        }

        public Criteria andIsSentNotBetween(Integer value1, Integer value2) {
            addCriterion("Is_Sent not between", value1, value2, "isSent");
            return (Criteria) this;
        }

        public Criteria andSentUserIsNull() {
            addCriterion("Sent_User is null");
            return (Criteria) this;
        }

        public Criteria andSentUserIsNotNull() {
            addCriterion("Sent_User is not null");
            return (Criteria) this;
        }

        public Criteria andSentUserEqualTo(String value) {
            addCriterion("Sent_User =", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserNotEqualTo(String value) {
            addCriterion("Sent_User <>", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserGreaterThan(String value) {
            addCriterion("Sent_User >", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserGreaterThanOrEqualTo(String value) {
            addCriterion("Sent_User >=", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserLessThan(String value) {
            addCriterion("Sent_User <", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserLessThanOrEqualTo(String value) {
            addCriterion("Sent_User <=", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserLike(String value) {
            addCriterion("Sent_User like", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserNotLike(String value) {
            addCriterion("Sent_User not like", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserIn(List<String> values) {
            addCriterion("Sent_User in", values, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserNotIn(List<String> values) {
            addCriterion("Sent_User not in", values, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserBetween(String value1, String value2) {
            addCriterion("Sent_User between", value1, value2, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserNotBetween(String value1, String value2) {
            addCriterion("Sent_User not between", value1, value2, "sentUser");
            return (Criteria) this;
        }

        public Criteria andIsQueryIsNull() {
            addCriterion("Is_Query is null");
            return (Criteria) this;
        }

        public Criteria andIsQueryIsNotNull() {
            addCriterion("Is_Query is not null");
            return (Criteria) this;
        }

        public Criteria andIsQueryEqualTo(Integer value) {
            addCriterion("Is_Query =", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryNotEqualTo(Integer value) {
            addCriterion("Is_Query <>", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryGreaterThan(Integer value) {
            addCriterion("Is_Query >", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryGreaterThanOrEqualTo(Integer value) {
            addCriterion("Is_Query >=", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryLessThan(Integer value) {
            addCriterion("Is_Query <", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryLessThanOrEqualTo(Integer value) {
            addCriterion("Is_Query <=", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryIn(List<Integer> values) {
            addCriterion("Is_Query in", values, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryNotIn(List<Integer> values) {
            addCriterion("Is_Query not in", values, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryBetween(Integer value1, Integer value2) {
            addCriterion("Is_Query between", value1, value2, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryNotBetween(Integer value1, Integer value2) {
            addCriterion("Is_Query not between", value1, value2, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsReturnIsNull() {
            addCriterion("Is_Return is null");
            return (Criteria) this;
        }

        public Criteria andIsReturnIsNotNull() {
            addCriterion("Is_Return is not null");
            return (Criteria) this;
        }

        public Criteria andIsReturnEqualTo(Integer value) {
            addCriterion("Is_Return =", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotEqualTo(Integer value) {
            addCriterion("Is_Return <>", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnGreaterThan(Integer value) {
            addCriterion("Is_Return >", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnGreaterThanOrEqualTo(Integer value) {
            addCriterion("Is_Return >=", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnLessThan(Integer value) {
            addCriterion("Is_Return <", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnLessThanOrEqualTo(Integer value) {
            addCriterion("Is_Return <=", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnIn(List<Integer> values) {
            addCriterion("Is_Return in", values, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotIn(List<Integer> values) {
            addCriterion("Is_Return not in", values, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnBetween(Integer value1, Integer value2) {
            addCriterion("Is_Return between", value1, value2, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotBetween(Integer value1, Integer value2) {
            addCriterion("Is_Return not between", value1, value2, "isReturn");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNull() {
            addCriterion("Return_Time is null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIsNotNull() {
            addCriterion("Return_Time is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTimeEqualTo(String value) {
            addCriterion("Return_Time =", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotEqualTo(String value) {
            addCriterion("Return_Time <>", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThan(String value) {
            addCriterion("Return_Time >", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeGreaterThanOrEqualTo(String value) {
            addCriterion("Return_Time >=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThan(String value) {
            addCriterion("Return_Time <", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLessThanOrEqualTo(String value) {
            addCriterion("Return_Time <=", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeLike(String value) {
            addCriterion("Return_Time like", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotLike(String value) {
            addCriterion("Return_Time not like", value, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeIn(List<String> values) {
            addCriterion("Return_Time in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotIn(List<String> values) {
            addCriterion("Return_Time not in", values, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeBetween(String value1, String value2) {
            addCriterion("Return_Time between", value1, value2, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnTimeNotBetween(String value1, String value2) {
            addCriterion("Return_Time not between", value1, value2, "returnTime");
            return (Criteria) this;
        }

        public Criteria andReturnUserIsNull() {
            addCriterion("Return_User is null");
            return (Criteria) this;
        }

        public Criteria andReturnUserIsNotNull() {
            addCriterion("Return_User is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUserEqualTo(String value) {
            addCriterion("Return_User =", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserNotEqualTo(String value) {
            addCriterion("Return_User <>", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserGreaterThan(String value) {
            addCriterion("Return_User >", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserGreaterThanOrEqualTo(String value) {
            addCriterion("Return_User >=", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserLessThan(String value) {
            addCriterion("Return_User <", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserLessThanOrEqualTo(String value) {
            addCriterion("Return_User <=", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserLike(String value) {
            addCriterion("Return_User like", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserNotLike(String value) {
            addCriterion("Return_User not like", value, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserIn(List<String> values) {
            addCriterion("Return_User in", values, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserNotIn(List<String> values) {
            addCriterion("Return_User not in", values, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserBetween(String value1, String value2) {
            addCriterion("Return_User between", value1, value2, "returnUser");
            return (Criteria) this;
        }

        public Criteria andReturnUserNotBetween(String value1, String value2) {
            addCriterion("Return_User not between", value1, value2, "returnUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeIsNull() {
            addCriterion("Last_UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeIsNotNull() {
            addCriterion("Last_UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeEqualTo(String value) {
            addCriterion("Last_UpdateTime =", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeNotEqualTo(String value) {
            addCriterion("Last_UpdateTime <>", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeGreaterThan(String value) {
            addCriterion("Last_UpdateTime >", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("Last_UpdateTime >=", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeLessThan(String value) {
            addCriterion("Last_UpdateTime <", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("Last_UpdateTime <=", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeLike(String value) {
            addCriterion("Last_UpdateTime like", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeNotLike(String value) {
            addCriterion("Last_UpdateTime not like", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeIn(List<String> values) {
            addCriterion("Last_UpdateTime in", values, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeNotIn(List<String> values) {
            addCriterion("Last_UpdateTime not in", values, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeBetween(String value1, String value2) {
            addCriterion("Last_UpdateTime between", value1, value2, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("Last_UpdateTime not between", value1, value2, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserIsNull() {
            addCriterion("Last_UpdateUser is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserIsNotNull() {
            addCriterion("Last_UpdateUser is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserEqualTo(String value) {
            addCriterion("Last_UpdateUser =", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserNotEqualTo(String value) {
            addCriterion("Last_UpdateUser <>", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserGreaterThan(String value) {
            addCriterion("Last_UpdateUser >", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("Last_UpdateUser >=", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserLessThan(String value) {
            addCriterion("Last_UpdateUser <", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("Last_UpdateUser <=", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserLike(String value) {
            addCriterion("Last_UpdateUser like", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserNotLike(String value) {
            addCriterion("Last_UpdateUser not like", value, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserIn(List<String> values) {
            addCriterion("Last_UpdateUser in", values, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserNotIn(List<String> values) {
            addCriterion("Last_UpdateUser not in", values, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserBetween(String value1, String value2) {
            addCriterion("Last_UpdateUser between", value1, value2, "lastUpdateuser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateuserNotBetween(String value1, String value2) {
            addCriterion("Last_UpdateUser not between", value1, value2, "lastUpdateuser");
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

        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("Address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("Address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("Order_Type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("Order_Type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("Order_Type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("Order_Type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("Order_Type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Order_Type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("Order_Type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("Order_Type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("Order_Type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("Order_Type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("Order_Type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("Order_Type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("Order_Type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("Order_Type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderBzIsNull() {
            addCriterion("Order_BZ is null");
            return (Criteria) this;
        }

        public Criteria andOrderBzIsNotNull() {
            addCriterion("Order_BZ is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBzEqualTo(String value) {
            addCriterion("Order_BZ =", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzNotEqualTo(String value) {
            addCriterion("Order_BZ <>", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzGreaterThan(String value) {
            addCriterion("Order_BZ >", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzGreaterThanOrEqualTo(String value) {
            addCriterion("Order_BZ >=", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzLessThan(String value) {
            addCriterion("Order_BZ <", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzLessThanOrEqualTo(String value) {
            addCriterion("Order_BZ <=", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzLike(String value) {
            addCriterion("Order_BZ like", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzNotLike(String value) {
            addCriterion("Order_BZ not like", value, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzIn(List<String> values) {
            addCriterion("Order_BZ in", values, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzNotIn(List<String> values) {
            addCriterion("Order_BZ not in", values, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzBetween(String value1, String value2) {
            addCriterion("Order_BZ between", value1, value2, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderBzNotBetween(String value1, String value2) {
            addCriterion("Order_BZ not between", value1, value2, "orderBz");
            return (Criteria) this;
        }

        public Criteria andOrderZtIsNull() {
            addCriterion("Order_ZT is null");
            return (Criteria) this;
        }

        public Criteria andOrderZtIsNotNull() {
            addCriterion("Order_ZT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderZtEqualTo(Integer value) {
            addCriterion("Order_ZT =", value, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtNotEqualTo(Integer value) {
            addCriterion("Order_ZT <>", value, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtGreaterThan(Integer value) {
            addCriterion("Order_ZT >", value, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("Order_ZT >=", value, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtLessThan(Integer value) {
            addCriterion("Order_ZT <", value, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtLessThanOrEqualTo(Integer value) {
            addCriterion("Order_ZT <=", value, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtIn(List<Integer> values) {
            addCriterion("Order_ZT in", values, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtNotIn(List<Integer> values) {
            addCriterion("Order_ZT not in", values, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtBetween(Integer value1, Integer value2) {
            addCriterion("Order_ZT between", value1, value2, "orderZt");
            return (Criteria) this;
        }

        public Criteria andOrderZtNotBetween(Integer value1, Integer value2) {
            addCriterion("Order_ZT not between", value1, value2, "orderZt");
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