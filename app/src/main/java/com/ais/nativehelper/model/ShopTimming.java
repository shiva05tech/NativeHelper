package com.ais.nativehelper.model;

import java.util.Date;

public class ShopTimming {

    private Long shopId;


    private int dayID;

    private Date openFrom;

    private Date openTo;

    private Date brkFrom;

    private Date brkTo;

    private String brkStatus;

    private String openStatus;

    private String timeStatus;

    private String weekStatus;

    private Long approved;

    private String remark;

    private String status;

    public ShopTimming() {
    }

    public ShopTimming(Long shopId, int dayID, Date openFrom, Date openTo, Date brkFrom, Date brkTo, String brkStatus, String openStatus, String timeStatus, String weekStatus, Long approved, String remark, String status) {
        this.shopId = shopId;
        this.dayID = dayID;
        this.openFrom = openFrom;
        this.openTo = openTo;
        this.brkFrom = brkFrom;
        this.brkTo = brkTo;
        this.brkStatus = brkStatus;
        this.openStatus = openStatus;
        this.timeStatus = timeStatus;
        this.weekStatus = weekStatus;
        this.approved = approved;
        this.remark = remark;
        this.status = status;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    public Date getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(Date openFrom) {
        this.openFrom = openFrom;
    }

    public Date getOpenTo() {
        return openTo;
    }

    public void setOpenTo(Date openTo) {
        this.openTo = openTo;
    }

    public Date getBrkFrom() {
        return brkFrom;
    }

    public void setBrkFrom(Date brkFrom) {
        this.brkFrom = brkFrom;
    }

    public Date getBrkTo() {
        return brkTo;
    }

    public void setBrkTo(Date brkTo) {
        this.brkTo = brkTo;
    }

    public String getBrkStatus() {
        return brkStatus;
    }

    public void setBrkStatus(String brkStatus) {
        this.brkStatus = brkStatus;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public String getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(String timeStatus) {
        this.timeStatus = timeStatus;
    }

    public String getWeekStatus() {
        return weekStatus;
    }

    public void setWeekStatus(String weekStatus) {
        this.weekStatus = weekStatus;
    }

    public Long getApproved() {
        return approved;
    }

    public void setApproved(Long approved) {
        this.approved = approved;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
