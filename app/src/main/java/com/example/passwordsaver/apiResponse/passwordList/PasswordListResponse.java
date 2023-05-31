package com.example.passwordsaver.apiResponse.passwordList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PasswordListResponse {

    @SerializedName("status_code")
    @Expose
    private int status_code;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("detail")
    @Expose
    private String detail;

    @SerializedName("data")
    @Expose
    private Data data;


//    public PasswordListResponse(int status_code, String status, String detail, Data data) {
//        this.status_code = status_code;
//        this.status = status;
//        this.detail = detail;
//        this.data = data;
//    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
