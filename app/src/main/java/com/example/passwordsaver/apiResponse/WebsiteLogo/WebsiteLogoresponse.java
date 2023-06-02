package com.example.passwordsaver.apiResponse.WebsiteLogo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WebsiteLogoresponse {
    @SerializedName("url")
    @Expose
    private  String url;

    @SerializedName("icons")
    @Expose
    private List<iconsData> iconsDataList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<iconsData> getIconsDataList() {
        return iconsDataList;
    }

    public void setIconsDataList(List<iconsData> iconsDataList) {
        this.iconsDataList = iconsDataList;
    }
}
