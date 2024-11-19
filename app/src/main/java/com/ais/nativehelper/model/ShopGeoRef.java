package com.ais.nativehelper.model;

public class ShopGeoRef {
    private Long shopId;

    private int trsnNo;

    private String title;

    private double latitude;

    private double longitude;

    private String priority;

    private String Status;

    private Long FinalApproved;

    private int visible;

    public ShopGeoRef() {
    }

    public ShopGeoRef(Long shopId, int trsnNo, String title, double latitude, double longitude, String priority, String status, Long finalApproved, int visible) {
        this.shopId = shopId;
        this.trsnNo = trsnNo;
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.priority = priority;
        Status = status;
        FinalApproved = finalApproved;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Long getFinalApproved() {
        return FinalApproved;
    }

    public void setFinalApproved(Long finalApproved) {
        FinalApproved = finalApproved;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
