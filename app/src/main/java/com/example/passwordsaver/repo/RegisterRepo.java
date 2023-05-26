package com.example.passwordsaver.repo;

import android.util.Log;

import com.example.passwordsaver.apiRequest.RegisterRequest;
import com.example.passwordsaver.apiResponse.RegisterResponse;
import com.example.passwordsaver.base.NetworkCallback;
import com.example.passwordsaver.base.RichMediatorLiveData;
import com.example.passwordsaver.data.DataManager;
import com.example.passwordsaver.models.FailureResponse;

public class RegisterRepo {

    public void hitRegisterApi(RichMediatorLiveData<RegisterResponse> liveData, RegisterRequest registerRequest){

        DataManager.getInstance().hitRegisterApi(registerRequest).enqueue(new NetworkCallback<RegisterResponse>() {
            @Override
            public void onSuccess(RegisterResponse registerResponse) {
                liveData.setValue(registerResponse);
            }

            @Override
            public void onFailure(FailureResponse failureResponse) {
                Log.d("hhhhhhhhhhhh", String.valueOf(failureResponse.getErrorMessage()));
                liveData.setFailure(failureResponse);
            }

            @Override
            public void onError(Throwable t) {
                Log.d("hhhhhhhhhhh", String.valueOf(t));
                liveData.setError(t);
            }
        });
    }
}
