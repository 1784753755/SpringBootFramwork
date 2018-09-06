package com.model;

import java.util.List;

/*商品*/
public class Goods {

    private Integer goodsId;

    private String title;
    /*分类*/
    private Integer goodsCategory;
    /*主图片采用  外键方式*/
    private Integer goodsImg;
    /*组合图片*/
    private String goodsListImg;
    /*商品单位*/
    private String goodsUnit;
    /*商品规格*/
    private String goodsSpec;
    /*商品产地*/
    private String goodsAddress;
    /*商品颜色*/
    private Integer goodsColor;
    /*商品库存*/
    private Integer goodsStore;
    /*商品标签*/
    private Integer goodsLabel;
    /*商品详情*/
    private String goodsDetail;
    /*商品排序*/
    private Integer goodsOrder;
    /*商品销售*/
    private Integer goodsCount;
    /*商品价格*/
    private float goodsPrice;
    /*商品原价*/
    private float goodsOldPrice;
    /*审核状态*/
    private Integer status;
    /*显示状态*/
    private Integer type;
    /*创建时间*/
    private String createTime;
    /*修改时间*/
    private String updateTime;
    /*商品尺码*/
    private String goodsSize;
    /*所属网站*/
    private Integer uId;
    /*币种*/
    private String goodsMoney;
    /**/
    private Integer total;
    /*是否置顶*/
    private Integer isTop;
    /*拼单人数设定*/
    private String goodsOnlyPrice;
    /*产品推荐热度*/
    private Integer isSort;
    /*用作输出*/
    private List<Color> colorList;
    private List<Package> packageList;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", title='" + title + '\'' +
                ", goodsCategory=" + goodsCategory +
                ", goodsImg=" + goodsImg +
                ", goodsListImg='" + goodsListImg + '\'' +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", goodsSpec='" + goodsSpec + '\'' +
                ", goodsAddress='" + goodsAddress + '\'' +
                ", goodsColor=" + goodsColor +
                ", goodsStore=" + goodsStore +
                ", goodsLabel=" + goodsLabel +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", goodsOrder=" + goodsOrder +
                ", goodsCount=" + goodsCount +
                ", goodsPrice=" + goodsPrice +
                ", goodsOldPrice=" + goodsOldPrice +
                ", status=" + status +
                ", type=" + type +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", goodsSize='" + goodsSize + '\'' +
                ", uId=" + uId +
                ", goodsMoney='" + goodsMoney + '\'' +
                ", total=" + total +
                ", isTop=" + isTop +
                ", goodsOnlyPrice='" + goodsOnlyPrice + '\'' +
                ", isSort=" + isSort +
                ", colorList=" + colorList +
                ", packageList=" + packageList +
                ", imgMain='" + imgMain + '\'' +
                ", imgList=" + imgList +
                '}';
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Package> packageList) {
        this.packageList = packageList;
    }

    public String getImgMain() {
        return imgMain;
    }

    public void setImgMain(String imgMain) {
        this.imgMain = imgMain;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    /*相册主图*/
    private String imgMain;
    /*商品相册*/
    private List<String> imgList;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(Integer goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public Integer getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(Integer goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsListImg() {
        return goodsListImg;
    }

    public void setGoodsListImg(String goodsListImg) {
        this.goodsListImg = goodsListImg;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }

    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }

    public Integer getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(Integer goodsColor) {
        this.goodsColor = goodsColor;
    }

    public Integer getGoodsStore() {
        return goodsStore;
    }

    public void setGoodsStore(Integer goodsStore) {
        this.goodsStore = goodsStore;
    }

    public Integer getGoodsLabel() {
        return goodsLabel;
    }

    public void setGoodsLabel(Integer goodsLabel) {
        this.goodsLabel = goodsLabel;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Integer getGoodsOrder() {
        return goodsOrder;
    }

    public void setGoodsOrder(Integer goodsOrder) {
        this.goodsOrder = goodsOrder;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public float getGoodsOldPrice() {
        return goodsOldPrice;
    }

    public void setGoodsOldPrice(float goodsOldPrice) {
        this.goodsOldPrice = goodsOldPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(String goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public String getGoodsOnlyPrice() {
        return goodsOnlyPrice;
    }

    public void setGoodsOnlyPrice(String goodsOnlyPrice) {
        this.goodsOnlyPrice = goodsOnlyPrice;
    }

    public Integer getIsSort() {
        return isSort;
    }

    public void setIsSort(Integer isSort) {
        this.isSort = isSort;
    }


}
