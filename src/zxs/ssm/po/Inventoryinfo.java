package zxs.ssm.po;

public class Inventoryinfo {
    private Integer commodityid;

    private Integer inventorynum;

    private String inventoryremark;

    private Integer tw;

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public Integer getInventorynum() {
        return inventorynum;
    }

    public void setInventorynum(Integer inventorynum) {
        this.inventorynum = inventorynum;
    }

    public String getInventoryremark() {
        return inventoryremark;
    }

    public void setInventoryremark(String inventoryremark) {
        this.inventoryremark = inventoryremark == null ? null : inventoryremark.trim();
    }

    public Integer getTw() {
        return tw;
    }

    public void setTw(Integer tw) {
        this.tw = tw;
    }
}