package com.model;

public class Picture {

   private  Integer FileId;
   private  String  imgUrl;
   private  String  type;
   private  Integer isThumb;
   private   Integer ImgPid;

    @Override
    public String toString() {
        return "Picture{" +
                "FileId=" + FileId +
                ", imgUrl='" + imgUrl + '\'' +
                ", type='" + type + '\'' +
                ", isThumb=" + isThumb +
                ", ImgPid=" + ImgPid +
                '}';
    }

    public Integer getFileId() {
        return FileId;
    }

    public void setFileId(Integer fileId) {
        FileId = fileId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsThumb() {
        return isThumb;
    }

    public void setIsThumb(Integer isThumb) {
        this.isThumb = isThumb;
    }

    public Integer getImgPid() {
        return ImgPid;
    }

    public void setImgPid(Integer imgPid) {
        ImgPid = imgPid;
    }
}
