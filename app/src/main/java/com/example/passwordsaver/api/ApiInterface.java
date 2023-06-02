package com.example.passwordsaver.api;

import com.example.passwordsaver.apiRequest.CreatePasswordRequest;
import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiRequest.RegisterRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.apiResponse.RegisterResponse;
import com.example.passwordsaver.apiResponse.WebsiteLogo.WebsiteLogoresponse;
import com.example.passwordsaver.apiResponse.createPassword.CreatePasswordResponse;
import com.example.passwordsaver.apiResponse.passwordList.PasswordListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("user/login/")
    Call<LoginResponse> hitLogin(@Body LoginRequest loginRequest);

    @POST("user/register/")
    Call<RegisterResponse> hitRegister(@Body RegisterRequest registerRequest);

    @GET("credential/create_get/")
    Call<PasswordListResponse> hitPasswordList();

    @GET("allicons.json")
    Call<WebsiteLogoresponse> hitFetchLogo(@Query("url") String url);

    @POST("credential/create_get/")
    Call<CreatePasswordResponse> hitCreatePassword(@Body CreatePasswordRequest createPasswordRequest);

}
