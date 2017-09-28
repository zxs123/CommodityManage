package zxs.ssm.po;

public class OrderInfo {
    private String orderNum;

    private String createTime;

    private String userId;

    private String sendTime;

    private Integer isSent;

    private String sentUser;

    private Integer isQuery;

    private Integer isReturn;

    private String returnTime;

    private String returnUser;

    private String lastUpdatetime;

    private String lastUpdateuser;

    private String customerName;

    private String telephone1;

    private String telephone2;

    private String address;

    private String orderType;

    private String orderBz;

    private Integer orderZt;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    public Integer getIsSent() {
        return isSent;
    }

    public void setIsSent(Integer isSent) {
        this.isSent = isSent;
    }

    public String getSentUser() {
        return sentUser;
    }

    public void setSentUser(String sentUser) {
        this.sentUser = sentUser == null ? null : sentUser.trim();
    }

    public Integer getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(Integer isQuery) {
        this.isQuery = isQuery;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime == null ? null : returnTime.trim();
    }

    public String getReturnUser() {
        return returnUser;
    }

    public void setReturnUser(String returnUser) {
        this.returnUser = returnUser == null ? null : returnUser.trim();
    }

    public String getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(String lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime == null ? null : lastUpdatetime.trim();
    }

    public String getLastUpdateuser() {
        return lastUpdateuser;
    }

    public void setLastUpdateuser(String lastUpdateuser) {
        this.lastUpdateuser = lastUpdateuser == null ? null : lastUpdateuser.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1 == null ? null : telephone1.trim();
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2 == null ? null : telephone2.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getOrderBz() {
        return orderBz;
    }

    public void setOrderBz(String orderBz) {
        this.orderBz = orderBz == null ? null : orderBz.trim();
    }

    public Integer getOrderZt() {
        return orderZt;
    }

    public void setOrderZt(Integer orderZt) {
        this.orderZt = orderZt;
    }
}