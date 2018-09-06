package com.model;

public class Config {
    private int configId;
    private String title;
    private String webMeta;
    /*网站名称*/
    private String webName;
    /*网站描述*/
    private String webDescription;
    /**/
    private int uid;
    /*ip黑名单*/
    private String ipList;


    /*邮箱账号*/
    private String emailName;
    /*端口号*/
    private Integer port;
    /*登录密码*/
    private String emailPwd;
    /*类型*/
    private String emailType;
    /*接受邮箱*/
    private String getEmail;
    /*自定义代码*/
    private String webCode;
    private String webSuccessCode;
    private String customerService;
    private String QrCode;
    private Integer checkAddress;
    private Integer checkPostcard;
    private Integer lineState;
    private Integer shippingCosts;
    /*大转盘状态*/
    private Integer largeTurntableState;
    /*中奖商品*/
    private String priseText = "";
    /*开启状态*/
    private Integer prizeType = 0;
    /*图片*/
    private String prizeImg = "";
    /*短信验证*/
    private String smsVerificationCode;
    /*选择模板*/
    private Integer model;

    @Override
    public String toString() {
        return "Config{" +
                "configId=" + this.configId +
                ", title='" + this.title + '\'' +
                ", webMeta='" + this.webMeta + '\'' +
                ", webName='" + this.webName + '\'' +
                ", webDescription='" + this.webDescription + '\'' +
                ", uid=" + this.uid +
                ", ipList='" + this.ipList + '\'' +
                ", emailName='" + this.emailName + '\'' +
                ", port=" + this.port +
                ", emailPwd='" + this.emailPwd + '\'' +
                ", emailType='" + this.emailType + '\'' +
                ", getEmail='" + this.getEmail + '\'' +
                ", webCode='" + this.webCode + '\'' +
                ", webSuccessCode='" + this.webSuccessCode + '\'' +
                ", customerService='" + this.customerService + '\'' +
                ", QrCode='" + this.QrCode + '\'' +
                ", checkAddress=" + this.checkAddress +
                ", checkPostcard=" + this.checkPostcard +
                ", lineState=" + this.lineState +
                ", shippingCosts=" + this.shippingCosts +
                ", largeTurntableState=" + this.largeTurntableState +
                ", priseText='" + this.priseText + '\'' +
                ", prizeType=" + this.prizeType +
                ", prizeImg='" + this.prizeImg + '\'' +
                ", smsVerificationCode='" + this.smsVerificationCode + '\'' +
                ", model=" + this.model +
                '}';
    }


    public int getConfigId() {
        return this.configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebMeta() {
        return this.webMeta;
    }

    public void setWebMeta(String webMeta) {
        this.webMeta = webMeta;
    }

    public String getWebName() {
        return this.webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebDescription() {
        return this.webDescription;
    }

    public void setWebDescription(String webDescription) {
        this.webDescription = webDescription;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIpList() {
        return this.ipList;
    }

    public void setIpList(String ipList) {
        this.ipList = ipList;
    }

    public String getEmailName() {
        return this.emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getEmailPwd() {
        return this.emailPwd;
    }

    public void setEmailPwd(String emailPwd) {
        this.emailPwd = emailPwd;
    }

    public String getEmailType() {
        return this.emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getGetEmail() {
        return this.getEmail;
    }

    public void setGetEmail(String getEmail) {
        this.getEmail = getEmail;
    }

    public String getWebCode() {
        return this.webCode;
    }

    public void setWebCode(String webCode) {
        this.webCode = webCode;
    }

    public String getWebSuccessCode() {
        return this.webSuccessCode;
    }

    public void setWebSuccessCode(String webSuccessCode) {
        this.webSuccessCode = webSuccessCode;
    }

    public String getCustomerService() {
        return this.customerService;
    }

    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    public String getQrCode() {
        return this.QrCode;
    }

    public void setQrCode(String qrCode) {
        this.QrCode = qrCode;
    }

    public Integer getCheckAddress() {
        return this.checkAddress;
    }

    public void setCheckAddress(Integer checkAddress) {
        this.checkAddress = checkAddress;
    }

    public Integer getCheckPostcard() {
        return this.checkPostcard;
    }

    public void setCheckPostcard(Integer checkPostcard) {
        this.checkPostcard = checkPostcard;
    }

    public Integer getLineState() {
        return this.lineState;
    }

    public void setLineState(Integer lineState) {
        this.lineState = lineState;
    }

    public Integer getShippingCosts() {
        return this.shippingCosts;
    }

    public void setShippingCosts(Integer shippingCosts) {
        this.shippingCosts = shippingCosts;
    }

    public Integer getLargeTurntableState() {
        return this.largeTurntableState;
    }

    public void setLargeTurntableState(Integer largeTurntableState) {
        this.largeTurntableState = largeTurntableState;
    }

    public String getPriseText() {
        return this.priseText;
    }

    public void setPriseText(String priseText) {
        this.priseText = priseText;
    }

    public Integer getPrizeType() {
        return this.prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    public String getPrizeImg() {
        return this.prizeImg;
    }

    public void setPrizeImg(String prizeImg) {
        this.prizeImg = prizeImg;
    }

    public String getSmsVerificationCode() {
        return this.smsVerificationCode;
    }

    public void setSmsVerificationCode(String smsVerificationCode) {
        this.smsVerificationCode = smsVerificationCode;
    }

    public Integer getModel() {
        return this.model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }
}
