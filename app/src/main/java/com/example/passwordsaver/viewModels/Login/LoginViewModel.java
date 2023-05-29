package com.example.passwordsaver.viewModels.Login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.passwordsaver.api.ApiManager;
import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.base.RichMediatorLiveData;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.repo.LoginRepo;
import com.example.passwordsaver.base.BaseViewModel;


public class LoginViewModel extends BaseViewModel {




    private LoginRepo loginRepo = new LoginRepo();


    private RichMediatorLiveData<LoginResponse> loginResponseRichMediatorLiveData;




    @Override
    public void initLiveData(){
        if(loginResponseRichMediatorLiveData == null){
            loginResponseRichMediatorLiveData = new RichMediatorLiveData<LoginResponse>() {
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





    public  RichMediatorLiveData<LoginResponse> liveDataLoginApi(){
        return loginResponseRichMediatorLiveData;
    }

    public  void  hitLogApi(LoginRequest loginRequest){
        loginRepo.hitLoginApi(loginResponseRichMediatorLiveData,loginRequest);
    }
}
