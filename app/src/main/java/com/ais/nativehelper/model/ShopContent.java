package com.ais.nativehelper.model;

public class ShopContent {
    private long ShopId;
    private int trsnNo;
    private String title;
    private String shopContent;
    private int priority;
    private int languageType;
    private String status;
    private long approved;
    private String createdDate;
    private int visible;

    public ShopContent() {
    }

    public ShopContent(long shopId, int trsnNo, String title, String shopContent, int priority, int languageType, String status, long approved, String createdDate, int visible) {
        ShopId = shopId;
        this.trsnNo = trsnNo;
        this.title = title;
        this.shopContent = shopContent;
        this.priority = priority;
        this.languageType = languageType;
        this.status = status;
        this.approved = approved;
        this.createdDate = createdDate;
        this.visible = visible;
    }

    public long getShopId() {
        return ShopId;
    }

    public void setShopId(long shopId) {
        ShopId = shopId;
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

    public String getShopContent() {
        return shopContent;
    }

    public void setShopContent(String shopContent) {
        this.shopContent = shopContent;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getLanguageType() {
        return languageType;
    }

    public void setLanguageType(int languageType) {
        this.languageType = languageType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getApproved() {
        return approved;
    }

    public void setApproved(long approved) {
        this.approved = approved;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
