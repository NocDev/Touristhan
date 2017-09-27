package com.example.touristhan.Data;

/**
 * Created by aadi on 27/9/17.
 */

public class Data {
    String name, subTitle;
    String imgUrl;

    public Data(String name, String subTitle, String imgUrl){
        this.name = name;
        this.subTitle = subTitle;
        this.imgUrl = imgUrl;
    }
    public Data(String name, String subTitle){
        this.name  = name;
        this.subTitle = subTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
