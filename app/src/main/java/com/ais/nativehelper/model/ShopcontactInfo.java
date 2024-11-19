package com.ais.nativehelper.model;

public class ShopcontactInfo {

    private Long shopId;

    private int trsnNo;

    private String title;

    private String mobileNo;

    private String email;

    private String status;

    private Long approved;

    private String mobVisible;

    private String emailVisible;

    private int visible;

    public ShopcontactInfo() {
    }

    public ShopcontactInfo(Long shopId, int trsnNo, String title, String mobileNo, String email, String status, Long approved, String mobVisible, String emailVisible, int visible) {
        this.shopId = shopId;
        this.trsnNo = trsnNo;
        this.title = title;
        this.mobileNo = mobileNo;
        this.email = email;
        this.status = status;
        this.approved = approved;
        this.mobVisible = mobVisible;
        this.emailVisible = emailVisible;
        this.visible = visible;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public int getTrsnNo() {
        return trsnNo;
    }

    public void setTrsnNo(int trsnNo) {
        this.trsnNo = trsnNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getApproved() {
        return approved;
    }

    public void setApproved(Long approved) {
        this.approved = approved;
    }

    public String getMobVisible() {
        return mobVisible;
    }

    public void setMobVisible(String mobVisible) {
        this.mobVisible = mobVisible;
    }

    public String getEmailVisible() {
        return emailVisible;
    }

    public void setEmailVisible(String emailVisible) {
        this.emailVisible = emailVisible;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
