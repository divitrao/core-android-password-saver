package com.example.passwordsaver.apiResponse.passwordList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CredentialList {

    @SerializedName("credential")
    @Expose
    private String credential;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("password")
    @Expose
    private String password;

//    public CredentialList(String credential, String website, String password) {
//        this.credential = credential;
//        this.website = website;
//        this.password = password;
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
