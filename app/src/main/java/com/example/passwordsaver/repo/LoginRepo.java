package com.example.passwordsaver.repo;

import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.base.NetworkCallback;
import com.example.passwordsaver.base.RichMediatorLiveData;
import com.example.passwordsaver.data.DataManager;
import com.example.passwordsaver.models.FailureResponse;

public class LoginRepo {

    public void hitLoginApi(RichMediatorLiveData<LoginResponse> liveData, LoginRequest loginRequest){

        DataManager.getInstance().hitLoginApi(loginRequest).enqueue(new NetworkCallback<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse loginResponse) {
                liveData.setValue(loginResponse);
            }

            @Override
            public void onFailure(FailureResponse failureResponse) {
                liveData.setFailure(failureResponse);
            }

            @Override
            public void onError(Throwable t) {
                liveData.setError(t);
            }
        });
    }
}
