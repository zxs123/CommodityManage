package zxs.ssm.po;

public class FunctionModule {
    private Integer fmId;

    private String fmName;

    private String fmAction;

    private Integer fmCategory;

    private String fmCatename;

    private String fmRemark;

    public Integer getFmId() {
        return fmId;
    }

    public void setFmId(Integer fmId) {
        this.fmId = fmId;
    }

    public String getFmName() {
        return fmName;
    }

    public void setFmName(String fmName) {
        this.fmName = fmName == null ? null : fmName.trim();
    }

    public String getFmAction() {
        return fmAction;
    }

    public void setFmAction(String fmAction) {
        this.fmAction = fmAction == null ? null : fmAction.trim();
    }

    public Integer getFmCategory() {
        return fmCategory;
    }

    public void setFmCategory(Integer fmCategory) {
        this.fmCategory = fmCategory;
    }

    public String getFmCatename() {
        return fmCatename;
    }

    public void setFmCatename(String fmCatename) {
        this.fmCatename = fmCatename == null ? null : fmCatename.trim();
    }

    public String getFmRemark() {
        return fmRemark;
    }

    public void setFmRemark(String fmRemark) {
        this.fmRemark = fmRemark == null ? null : fmRemark.trim();
    }
}