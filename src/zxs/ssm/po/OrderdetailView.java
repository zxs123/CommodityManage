package zxs.ssm.po;

public class OrderdetailView {
    private String orderNum;

    private String commoditymarque;

    private String commodityname;

    private String commodityscale;

    private Integer inventorynum;

    private Integer commodityNum;

    private Integer commodityid;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getCommoditymarque() {
        return commoditymarque;
    }

    public void setCommoditymarque(String commoditymarque) {
        this.commoditymarque = commoditymarque == null ? null : commoditymarque.trim();
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname == null ? null : commodityname.trim();
    }

    public String getCommodityscale() {
        return commodityscale;
    }

    public void setCommodityscale(String commodityscale) {
        this.commodityscale = commodityscale == null ? null : commodityscale.trim();
    }

    public Integer getInventorynum() {
        return inventorynum;
    }

    public void setInventorynum(Integer inventorynum) {
        this.inventorynum = inventorynum;
    }

    public Integer getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(Integer commodityNum) {
        this.commodityNum = commodityNum;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }
}