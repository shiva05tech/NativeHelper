package com.ais.nativehelper.model;

public class NewsHeadline {
    private long newsID;

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    private String newsHeading;
    private String languageType;
    private  long createdBY;
    private String name;
    private String newscloseDate;
    private int newscategory;
    private String imageUrl;
    private String finalStatus;
    private long views;

    public NewsHeadline() {
        super();
        // TODO Auto-generated constructor stub
    }

    public NewsHeadline(long newsID, String newsHeading, String languageType, long createdBY, String name,
                        String newscloseDate, int newscategory, String imageUrl, String finalStatus,long views) {
        super();
        this.newsID = newsID;
        this.newsHeading = newsHeading;
        this.languageType = languageType;
        this.createdBY = createdBY;
        this.name = name;
        this.newscloseDate = newscloseDate;
        this.newscategory = newscategory;
        this.imageUrl = imageUrl;
        this.finalStatus = finalStatus;
        this.views=views;
    }

    public long getNewsID() {
        return newsID;
    }

    public void setNewsID(long newsID) {
        this.newsID = newsID;
    }

    public String getNewsHeading() {
        return newsHeading;
    }

    public void setNewsHeading(String newsHeading) {
        this.newsHeading = newsHeading;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewscloseDate() {
        return newscloseDate;
    }

    public void setNewscloseDate(String newscloseDate) {
        this.newscloseDate = newscloseDate;
    }

    public int getNewscategory() {
        return newscategory;
    }

    public void setNewscategory(int newscategory) {
        this.newscategory = newscategory;
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






	/*select nm.NewsID,nm.newsHeading , nm.languageType ,nm.createdBY ,ur.name,nm.newscloseDate,
	 * nm.newscategory,nimg.imageUrl ,nm.finalStatus
	from  newsMain nm inner join NewsImages nimg on nm.NewsID=nm.NewsID  and nm.finalStatus=nimg.Status
	 inner join users ur on nm.createdBY=ur.id
	 where nm.DistrictID=2 and nm.TalukId=1
	 and nm.Region=1
	 and nm.NewsStatus=1
	 and nm.finalStatus='FAD'
	 group by nm.NewsID
	 order by nm.newscloseDate
	 limit 2;*/

}