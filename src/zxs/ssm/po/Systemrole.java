package zxs.ssm.po;

public class Systemrole {
    private Integer srId;

    private String srName;

    private String srReid;

    public Integer getSrId() {
        return srId;
    }

    public void setSrId(Integer srId) {
        this.srId = srId;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName == null ? null : srName.trim();
    }

    public String getSrReid() {
        return srReid;
    }

    public void setSrReid(String srReid) {
        this.srReid = srReid == null ? null : srReid.trim();
    }
}