package zxs.ssm.po;

public class Alterinfo {
    private Integer alterid;

    private Integer commodityid;

    private String altertime;

    private String altertype;

    private Integer alternum;

    private Integer alterinventory;

    private String username;

    private String orderNum;

    private String alterremark;

    private Integer zt;

    public Integer getAlterid() {
        return alterid;
    }

    public void setAlterid(Integer alterid) {
        this.alterid = alterid;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getAltertime() {
        return altertime;
    }

    public void setAltertime(String altertime) {
        this.altertime = altertime == null ? null : altertime.trim();
    }

    public String getAltertype() {
        return altertype;
    }

    public void setAltertype(String altertype) {
        this.altertype = altertype == null ? null : altertype.trim();
    }

    public Integer getAlternum() {
        return alternum;
    }

    public void setAlternum(Integer alternum) {
        this.alternum = alternum;
    }

    public Integer getAlterinventory() {
        return alterinventory;
    }

    public void setAlterinventory(Integer alterinventory) {
        this.alterinventory = alterinventory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getAlterremark() {
        return alterremark;
    }

    public void setAlterremark(String alterremark) {
        this.alterremark = alterremark == null ? null : alterremark.trim();
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }
}