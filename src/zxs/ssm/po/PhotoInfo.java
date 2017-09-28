package zxs.ssm.po;

public class PhotoInfo {
    private Integer photoId;

    private String orderNum;

    private String relationNum;

    private String photo;

    private String userName;

    private String commitTime;

    private String photoType;

    private String photoBz;

    private Integer photoZt;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getRelationNum() {
        return relationNum;
    }

    public void setRelationNum(String relationNum) {
        this.relationNum = relationNum == null ? null : relationNum.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime == null ? null : commitTime.trim();
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType == null ? null : photoType.trim();
    }

    public String getPhotoBz() {
        return photoBz;
    }

    public void setPhotoBz(String photoBz) {
        this.photoBz = photoBz == null ? null : photoBz.trim();
    }

    public Integer getPhotoZt() {
        return photoZt;
    }

    public void setPhotoZt(Integer photoZt) {
        this.photoZt = photoZt;
    }
}