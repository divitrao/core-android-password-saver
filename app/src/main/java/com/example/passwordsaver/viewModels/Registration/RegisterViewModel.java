package com.example.passwordsaver.viewModels.Registration;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiRequest.RegisterRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.apiResponse.RegisterResponse;
import com.example.passwordsaver.base.BaseViewModel;
import com.example.passwordsaver.base.RichMediatorLiveData;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.repo.RegisterRepo;

public class RegisterViewModel extends BaseViewModel {

    private RegisterRepo registerRepo = new RegisterRepo();

    private RichMediatorLiveData<RegisterResponse> registerResponseRichMediatorLiveData;

    @Override
    public void initLiveData() {

        Log.d("ddddddddddddddddd","[]][][][][][[]]]");

        if(registerResponseRichMediatorLiveData == null){
            Log.d("dddddddddddddd", String.valueOf(registerResponseRichMediatorLiveData));
            Log.d("dddddddewewqwe", String.valueOf(mFailureObserver));
            registerResponseRichMediatorLiveData = new RichMediatorLiveData<RegisterResponse>() {
                @Override
                protected Observer<FailureResponse> getFailureObserver() {
                    return mFailureObserver;
                }

                @Override
                protected Observer<Throwable> getErrorObserver() {
                    return mErrorObserver;
                }
            };
        }

    }

    public  RichMediatorLiveData<RegisterResponse> liveDataRegisterApi(){
        Log.d("dddddddddddd", String.valueOf(registerResponseRichMediatorLiveData));
        return registerResponseRichMediatorLiveData;
    }

    public  void  hitRegisterApi(RegisterRequest registerRequest){
        registerRepo.hitRegisterApi(registerResponseRichMediatorLiveData,registerRequest);
    }
}
