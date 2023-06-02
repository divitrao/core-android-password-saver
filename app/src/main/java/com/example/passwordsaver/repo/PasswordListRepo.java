package com.example.passwordsaver.repo;

import com.example.passwordsaver.apiRequest.CreatePasswordRequest;
import com.example.passwordsaver.apiResponse.createPassword.CreatePasswordResponse;
import com.example.passwordsaver.apiResponse.passwordList.PasswordListResponse;
import com.example.passwordsaver.base.NetworkCallback;
import com.example.passwordsaver.base.RichMediatorLiveData;
import com.example.passwordsaver.data.DataManager;
import com.example.passwordsaver.models.FailureResponse;

public class PasswordListRepo {

    public void hitPasswordList(RichMediatorLiveData<PasswordListResponse> liveData){

        DataManager.getInstance().hitPasswordList().enqueue(new NetworkCallback<PasswordListResponse>() {
            @Override
            public void onSuccess(PasswordListResponse passwordListResponse) {
                liveData.setValue(passwordListResponse);
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

    public void hitCreatePassword(RichMediatorLiveData<CreatePasswordResponse> liveData, CreatePasswordRequest createPasswordRequest){
        DataManager.getInstance().hitCreatePassword(createPasswordRequest).enqueue(new NetworkCallback<CreatePasswordResponse>() {
            @Override
            public void onSuccess(CreatePasswordResponse createPasswordResponse) {
                liveData.setValue(createPasswordResponse);
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
