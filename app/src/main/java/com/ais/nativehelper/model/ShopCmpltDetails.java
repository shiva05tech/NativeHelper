package com.ais.nativehelper.model;

import java.util.List;

public class ShopCmpltDetails {
    private long shopId ;
    private String shopName;
    private String shopTitle;
    private long userId;
    private String userName;
    private int mcatId;
    private int subcatId;
    private String phNo;
    private Integer districtID;
    private Integer talukID;
    private Integer region;
    private int  languageType;
    private int priority;
    private String identity;
    private String status;
    private List<ShopContent> contentList;
    private List<ShopImages> imageList;
    private List<ShopAddress> adressList;
    private List<ShopcontactInfo> contList;
    private List<ShopTimming> timmimg;
    private List<ShopGeoRef> shopGeoRef;
    private ShopOpenStatus openStatus;
    private String tdyStatus;

    public ShopCmpltDetails() {

    }

    public ShopCmpltDetails(long shopId, String shopName, String shopTitle, long userId, String userName, int mcatId, int subcatId, String phNo, Integer districtID, Integer talukID, Integer region, int languageType, int priority, String identity, String status, List<ShopContent> contentList, List<ShopImages> imageList, List<ShopAddress> adressList, List<ShopcontactInfo> contList, List<ShopTimming> timmimg, List<ShopGeoRef> shopGeoRef, ShopOpenStatus openStatus, String tdyStatus) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopTitle = shopTitle;
        this.userId = userId;
        this.userName = userName;
        this.mcatId = mcatId;
        this.subcatId = subcatId;
        this.phNo = phNo;
        this.districtID = districtID;
        this.talukID = talukID;
        this.region = region;
        this.languageType = languageType;
        this.priority = priority;
        this.identity = identity;
        this.status = status;
        this.contentList = contentList;
        this.imageList = imageList;
        this.adressList = adressList;
        this.contList = contList;
        this.timmimg = timmimg;
        this.shopGeoRef = shopGeoRef;
        this.openStatus = openStatus;
        this.tdyStatus = tdyStatus;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMcatId() {
        return mcatId;
    }

    public void setMcatId(int mcatId) {
        this.mcatId = mcatId;
    }

    public int getSubcatId() {
        return subcatId;
    }

    public void setSubcatId(int subcatId) {
        this.subcatId = subcatId;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public Integer getTalukID() {
        return talukID;
    }

    public void setTalukID(Integer talukID) {
        this.talukID = talukID;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public int getLanguageType() {
        return languageType;
    }

    public void setLanguageType(int languageType) {
        this.languageType = languageType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ShopContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<ShopContent> contentList) {
        this.contentList = contentList;
    }

    public List<ShopImages> getImageList() {
        return imageList;
    }

    public void setImageList(List<ShopImages> imageList) {
        this.imageList = imageList;
    }

    public List<ShopAddress> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<ShopAddress> adressList) {
        this.adressList = adressList;
    }

    public List<ShopcontactInfo> getContList() {
        return contList;
    }

    public void setContList(List<ShopcontactInfo> contList) {
        this.contList = contList;
    }

    public List<ShopTimming> getTimmimg() {
        return timmimg;
    }

    public void setTimmimg(List<ShopTimming> timmimg) {
        this.timmimg = timmimg;
    }

    public List<ShopGeoRef> getShopGeoRef() {
        return shopGeoRef;
    }

    public void setShopGeoRef(List<ShopGeoRef> shopGeoRef) {
        this.shopGeoRef = shopGeoRef;
    }

    public ShopOpenStatus getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(ShopOpenStatus openStatus) {
        this.openStatus = openStatus;
    }

    public String getTdyStatus() {
        return tdyStatus;
    }

    public void setTdyStatus(String tdyStatus) {
        this.tdyStatus = tdyStatus;
    }
}
