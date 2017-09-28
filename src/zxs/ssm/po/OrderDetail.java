package zxs.ssm.po;

public class OrderDetail {
    private Integer detailId;

    private String orderNum;

    private String commodityMarque;

    private Integer commodityNum;

    private Integer detailZt;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getCommodityMarque() {
        return commodityMarque;
    }

    public void setCommodityMarque(String commodityMarque) {
        this.commodityMarque = commodityMarque == null ? null : commodityMarque.trim();
    }

    public Integer getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(Integer commodityNum) {
        this.commodityNum = commodityNum;
    }

    public Integer getDetailZt() {
        return detailZt;
    }

    public void setDetailZt(Integer detailZt) {
        this.detailZt = detailZt;
    }
}