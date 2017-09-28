package zxs.ssm.po;

public class ExpressInfo extends ExpressInfoKey {
    private String expressCompany;

    private Double expressCost;

    private String updateUser;

    private String updateTime;

    private Integer expressZt;

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    public Double getExpressCost() {
        return expressCost;
    }

    public void setExpressCost(Double expressCost) {
        this.expressCost = expressCost;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getExpressZt() {
        return expressZt;
    }

    public void setExpressZt(Integer expressZt) {
        this.expressZt = expressZt;
    }
}