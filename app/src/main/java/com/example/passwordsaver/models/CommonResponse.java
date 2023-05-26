package com.example.passwordsaver.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonResponse {
    @SerializedName("statusCode")
    @Expose
    private Integer cODE;
    @SerializedName("message")
    @Expose
    private String mESSAGE;


    public Integer getCODE() {
        return cODE;
    }

    public void setCODE(Integer cODE) {
        this.cODE = cODE;
    }

    public String getMESSAGE() {
        return mESSAGE;
    }

    public void setMESSAGE(String mESSAGE) {
        this.mESSAGE = mESSAGE;
    }


}
