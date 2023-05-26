package com.example.passwordsaver.apiResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("refresh")
    @Expose
    private String  refresh;

    @SerializedName("access")
    @Expose
    private String access;

    public LoginResponse(String refresh, String access) {
        this.refresh = refresh;
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }


}
