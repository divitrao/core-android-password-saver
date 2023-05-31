package com.example.passwordsaver.api;


import com.example.passwordsaver.BuildConfig;
import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiRequest.RegisterRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.apiResponse.RegisterResponse;
import com.example.passwordsaver.apiResponse.passwordList.PasswordListResponse;
import com.example.passwordsaver.constants.AppConstants;
import com.example.passwordsaver.data.DataManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;


public class ApiManager {
    private static final ApiManager instance = new ApiManager();
    private ApiInterface apiClient;

    private ApiInterface apiAuthenticatedClient;

    public static ApiManager getInstance() {
        return instance;
    }

    private ApiManager() {

        apiClient = getRetrofitService();
        apiAuthenticatedClient = getAuthenticatedretrofitService();
    }

    private ApiInterface getRetrofitService(){
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retorfit = retrofitBuilder.build();
        return retorfit.create(ApiInterface.class);
    }

    private  ApiInterface getAuthenticatedretrofitService(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        httpClient.addInterceptor(interceptor).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                String access_token = DataManager.getInstance().getAccessToken();

                Request.Builder requester = original.newBuilder()
                        .header(AppConstants.AUTHORIZATION,"Bearer "+access_token);

                Request request = requester.build();
                return  chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client).build();
        return  retrofit.create(ApiInterface.class);

    }

    public Call<LoginResponse> hitLoginApi(LoginRequest loginRequest){
        return  apiClient.hitLogin(loginRequest);
    }

    public  Call<RegisterResponse> hitRegisterApi(RegisterRequest registerRequest){
        return  apiClient.hitRegister(registerRequest);
    }

    public Call<PasswordListResponse> hitPasswordList(){
        return apiAuthenticatedClient.hitPasswordList();
    }
}
