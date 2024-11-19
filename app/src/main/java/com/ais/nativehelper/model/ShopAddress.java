package com.ais.nativehelper.model;

public class ShopAddress {
    private Long shopId;

    private int trsnNo;

    private String line1;

    private String line2;

    private String area;

    private String area2;

    private int pincode;

    private int districtID;

    private int talukID;

    private int region;

    private String priority;

    private String Status;

    private Long FinalApproved;

    public ShopAddress() {
    }

    public ShopAddress(Long shopId, int trsnNo, String line1, String line2, String area, String area2, int pincode, int districtID, int talukID, int region, String priority, String status, Long finalApproved) {
        this.shopId = shopId;
        this.trsnNo = trsnNo;
        this.line1 = line1;
        this.line2 = line2;
        this.area = area;
        this.area2 = area2;
        this.pincode = pincode;
        this.districtID = districtID;
        this.talukID = talukID;
        this.region = region;
        this.priority = priority;
        Status = status;
        FinalApproved = finalApproved;
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

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public int getTalukID() {
        return talukID;
    }

    public void setTalukID(int talukID) {
        this.talukID = talukID;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
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
}
