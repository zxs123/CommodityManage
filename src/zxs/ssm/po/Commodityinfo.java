package zxs.ssm.po;

public class Commodityinfo {
    private Integer commodityid;

    private String commodityname;

    private String commoditytype;

    private String commodityscale;

    private String commoditymarque;

    private String commodityunit;

    private Integer qiyong;

    private Integer inventorynum;

    private Integer zt;

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname == null ? null : commodityname.trim();
    }

    public String getCommoditytype() {
        return commoditytype;
    }

    public void setCommoditytype(String commoditytype) {
        this.commoditytype = commoditytype == null ? null : commoditytype.trim();
    }

    public String getCommodityscale() {
        return commodityscale;
    }

    public void setCommodityscale(String commodityscale) {
        this.commodityscale = commodityscale == null ? null : commodityscale.trim();
    }

    public String getCommoditymarque() {
        return commoditymarque;
    }

    public void setCommoditymarque(String commoditymarque) {
        this.commoditymarque = commoditymarque == null ? null : commoditymarque.trim();
    }

    public String getCommodityunit() {
        return commodityunit;
    }

    public void setCommodityunit(String commodityunit) {
        this.commodityunit = commodityunit == null ? null : commodityunit.trim();
    }

    public Integer getQiyong() {
        return qiyong;
    }

    public void setQiyong(Integer qiyong) {
        this.qiyong = qiyong;
    }

    public Integer getInventorynum() {
        return inventorynum;
    }

    public void setInventorynum(Integer inventorynum) {
        this.inventorynum = inventorynum;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }
}