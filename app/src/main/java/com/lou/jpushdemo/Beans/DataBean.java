package com.jiyun.jpushdemo.Beans;

public class DataBean {
    /**
     * uniquekey : 249c142a43a8f5aff743377b5e1cf157
     * title : 新时代、新坐标 读懂四大施政重点布局
     * date : 2018-03-27 09:15
     * category : 头条
     * author_name : 半月谈
     * url : http://mini.eastday.com/mobile/180327091525466.html
     * thumbnail_pic_s : http://07.imgmini.eastday.com/mobile/20180327/20180327091525_5fc561a9384ac72bd3017be177847f78_3_mwpm_03200403.jpg
     * thumbnail_pic_s02 : http://07.imgmini.eastday.com/mobile/20180327/20180327091525_64e0220d45dd6fcb2234498110e878f9_2_mwpm_03200403.jpg
     * thumbnail_pic_s03 : http://07.imgmini.eastday.com/mobile/20180327/20180327091525_2cf28f0e13d439d545c7df42d733d76c_1_mwpm_03200403.jpg
     */

    private String uniquekey;
    private String title;
    private String date;
    private String category;
    private String author_name;
    private String url;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;
    private String thumbnail_pic_s03;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }

    public DataBean(String title, String author_name, String thumbnail_pic_s) {
        this.title = title;
        this.author_name = author_name;
        this.thumbnail_pic_s = thumbnail_pic_s;
    }
}
