package com.ais.nativehelper.model;

import java.util.Date;

public class ShopOpenStatus {

    private Long id;

    private Long shopId;

    private Long userId;

    private Date date;

    private String openStatus;

    private String status;

    public ShopOpenStatus() {
    }

    public ShopOpenStatus(Long id, Long shopId, Long userId, Date date, String openStatus, String status) {
        this.id = id;
        this.shopId = shopId;
        this.userId = userId;
        this.date = date;
        this.openStatus = openStatus;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
