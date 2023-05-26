package com.example.passwordsaver.api;

import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiRequest.RegisterRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.apiResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("user/login/")
    Call<LoginResponse> hitLogin(@Body LoginRequest loginRequest);

    @POST("user/register/")
    Call<RegisterResponse> hitRegister(@Body RegisterRequest registerRequest);
}
