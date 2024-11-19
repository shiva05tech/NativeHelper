package com.ais.nativehelper.model;

import java.util.Date;

public class ShopHeader {

    private long shopId;
    private String shopName;
    private String shopTitle;
    private String languageType;
    private long createdBY;
    private long userId;
    private String name;
    private Date date;
    private int mctId;
    private int subCatId;
    private String resourcePhNo;
    private String imageUrl;
    private String finalStatus;
    private String catName;
    private int View;

    public ShopHeader() {
    }

    public ShopHeader(long shopId, String shopName, String shopTitle, String languageType, long createdBY, long userId, String name, Date date, int mctId, int subCatId, String resourcePhNo, String imageUrl, String finalStatus, String catName, int view) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopTitle = shopTitle;
        this.languageType = languageType;
        this.createdBY = createdBY;
        this.userId = userId;
        this.name = name;
        this.date = date;
        this.mctId = mctId;
        this.subCatId = subCatId;
        this.resourcePhNo = resourcePhNo;
        this.imageUrl = imageUrl;
        this.finalStatus = finalStatus;
        this.catName = catName;
        View = view;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    public long getCreatedBY() {
        return createdBY;
    }

    public void setCreatedBY(long createdBY) {
        this.createdBY = createdBY;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMctId() {
        return mctId;
    }

    public void setMctId(int mctId) {
        this.mctId = mctId;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }

    public String getResourcePhNo() {
        return resourcePhNo;
    }

    public void setResourcePhNo(String resourcePhNo) {
        this.resourcePhNo = resourcePhNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getView() {
        return View;
    }

    public void setView(int view) {
        View = view;
    }
}
