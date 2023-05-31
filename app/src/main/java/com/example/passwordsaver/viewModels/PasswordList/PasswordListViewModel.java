package com.example.passwordsaver.viewModels.PasswordList;

import androidx.lifecycle.Observer;

import com.example.passwordsaver.apiResponse.passwordList.PasswordListResponse;
import com.example.passwordsaver.base.BaseViewModel;
import com.example.passwordsaver.base.RichMediatorLiveData;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.repo.PasswordListRepo;

public class PasswordListViewModel extends BaseViewModel {

    private PasswordListRepo passwordListRepo = new PasswordListRepo();

    private RichMediatorLiveData<PasswordListResponse> passwordListResponseRichMediatorLiveData;
    @Override
    public void initLiveData() {
        if(passwordListResponseRichMediatorLiveData==null){

            passwordListResponseRichMediatorLiveData = new RichMediatorLiveData<PasswordListResponse>() {
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

    public RichMediatorLiveData<PasswordListResponse> getPasswordListResponseRichMediatorLiveData() {
        return passwordListResponseRichMediatorLiveData;
    }

    public void hitPasswordList(){
        passwordListRepo.hitPasswordList(passwordListResponseRichMediatorLiveData);
    }
}
