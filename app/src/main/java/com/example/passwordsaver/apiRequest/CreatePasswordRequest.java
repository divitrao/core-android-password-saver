package com.example.passwordsaver.apiRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePasswordRequest {
    @SerializedName("credential")
    @Expose
    private String credential;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("password1")
    @Expose
    private String password1;

    @SerializedName("password2")
    @Expose
    private String password2;


    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
