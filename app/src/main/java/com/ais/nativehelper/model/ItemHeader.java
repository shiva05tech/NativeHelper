package com.ais.nativehelper.model;

import java.util.Date;

public class ItemHeader {
    private long onlineId;
    private long shopId;
    private long ItemID;
    private long shopuserId;
    private int lanType;
    private double Mrp;
    private double price;
    private String Unit;
    private String brandName;
    private String itemStatus;
    private String finalStatus;
    private int mcatId;
    private int subCatId;
    private String eName;
    private String kName;
    private String itemImageUrl;
    private String itemUnit;
    private String onlitemUrl;

    public ItemHeader() {
    }

    public ItemHeader(long onlineId, long shopId, long itemID, long shopuserId, int lanType, double mrp, double price, String unit, String brandName, String itemStatus, String finalStatus, int mcatId, int subCatId, String eName, String kName, String itemImageUrl, String itemUnit, String onlitemUrl) {
        this.onlineId = onlineId;
        this.shopId = shopId;
        ItemID = itemID;
        this.shopuserId = shopuserId;
        this.lanType = lanType;
        Mrp = mrp;
        this.price = price;
        Unit = unit;
        this.brandName = brandName;
        this.itemStatus = itemStatus;
        this.finalStatus = finalStatus;
        this.mcatId = mcatId;
        this.subCatId = subCatId;
        this.eName = eName;
        this.kName = kName;
        this.itemImageUrl = itemImageUrl;
        this.itemUnit = itemUnit;
        this.onlitemUrl = onlitemUrl;
    }

    public long getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(long onlineId) {
        this.onlineId = onlineId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getItemID() {
        return ItemID;
    }

    public void setItemID(long itemID) {
        ItemID = itemID;
    }

    public long getShopuserId() {
        return shopuserId;
    }

    public void setShopuserId(long shopuserId) {
        this.shopuserId = shopuserId;
    }

    public int getLanType() {
        return lanType;
    }

    public void setLanType(int lanType) {
        this.lanType = lanType;
    }

    public double getMrp() {
        return Mrp;
    }

    public void setMrp(double mrp) {
        Mrp = mrp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public int getMcatId() {
        return mcatId;
    }

    public void setMcatId(int mcatId) {
        this.mcatId = mcatId;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getOnlitemUrl() {
        return onlitemUrl;
    }

    public void setOnlitemUrl(String onlitemUrl) {
        this.onlitemUrl = onlitemUrl;
    }
}
