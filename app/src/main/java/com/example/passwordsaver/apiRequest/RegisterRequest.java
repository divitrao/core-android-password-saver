package com.example.passwordsaver.apiRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private  String password;

    @SerializedName("password2")
    @Expose
    private  String password2;

//    public RegisterRequest(String username, String password, String password2) {
//        this.username = username;
//        this.password = password;
//        this.password2 = password2;
//    }
//
//    public RegisterRequest() {
//
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }


}
