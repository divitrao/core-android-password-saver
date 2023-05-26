package com.example.passwordsaver.api;


import com.example.passwordsaver.BuildConfig;
import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiRequest.RegisterRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.apiResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;


public class ApiManager {
    private static final ApiManager instance = new ApiManager();
    private ApiInterface apiClient;

    public static ApiManager getInstance() {
        return instance;
    }

    private ApiManager() {

        apiClient = getAuthenticatedRetrofitService();
    }

    private ApiInterface getAuthenticatedRetrofitService(){
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retorfit = retrofitBuilder.build();
        return retorfit.create(ApiInterface.class);
    }

    public Call<LoginResponse> hitLoginApi(LoginRequest loginRequest){
        return  apiClient.hitLogin(loginRequest);
    }

    public  Call<RegisterResponse> hitRegisterApi(RegisterRequest registerRequest){
        return  apiClient.hitRegister(registerRequest);
    }
}
