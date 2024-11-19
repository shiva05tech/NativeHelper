package com.ais.nativehelper.model;

public class ShopImages {


    private Long shopId;


    private int trsnNo;

    private String title;

    private String imageUrl ;

    private int priority;

    private String status;

    private Long approved;

    private String fileName;

    private int Visible;

    private String   createdDate;

    public ShopImages() {
    }

    public ShopImages(Long shopId, int trsnNo, String title, String imageUrl, int priority, String status, Long approved, String fileName, int visible, String createdDate) {
        this.shopId = shopId;
        this.trsnNo = trsnNo;
        this.title = title;
        this.imageUrl = imageUrl;
        this.priority = priority;
        this.status = status;
        this.approved = approved;
        this.fileName = fileName;
        Visible = visible;
        this.createdDate = createdDate;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getVisible() {
        return Visible;
    }

    public void setVisible(int visible) {
        Visible = visible;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
