package zxs.ssm.po;

public class Department {
    private String depId;

    private String depName;

    private Integer depSort;

    private String depRemark;

    private Integer depQueue;

    private Integer depAssess;

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public Integer getDepSort() {
        return depSort;
    }

    public void setDepSort(Integer depSort) {
        this.depSort = depSort;
    }

    public String getDepRemark() {
        return depRemark;
    }

    public void setDepRemark(String depRemark) {
        this.depRemark = depRemark == null ? null : depRemark.trim();
    }

    public Integer getDepQueue() {
        return depQueue;
    }

    public void setDepQueue(Integer depQueue) {
        this.depQueue = depQueue;
    }

    public Integer getDepAssess() {
        return depAssess;
    }

    public void setDepAssess(Integer depAssess) {
        this.depAssess = depAssess;
    }
}