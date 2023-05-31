package com.example.passwordsaver.repo;

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
}
