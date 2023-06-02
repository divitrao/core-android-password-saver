package com.example.passwordsaver.viewModels.CreatePassword;

import androidx.lifecycle.Observer;

import com.example.passwordsaver.apiRequest.CreatePasswordRequest;
import com.example.passwordsaver.apiResponse.createPassword.CreatePasswordResponse;
import com.example.passwordsaver.apiResponse.passwordList.PasswordListResponse;
import com.example.passwordsaver.base.BaseViewModel;
import com.example.passwordsaver.base.RichMediatorLiveData;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.repo.PasswordListRepo;

public class CreatePasswordViewModel extends BaseViewModel {

    private PasswordListRepo passwordListRepo = new PasswordListRepo();

    private RichMediatorLiveData<CreatePasswordResponse> createPasswordResponseRichMediatorLiveData;
    @Override
    public void initLiveData() {
        if(createPasswordResponseRichMediatorLiveData==null){

            createPasswordResponseRichMediatorLiveData = new RichMediatorLiveData<CreatePasswordResponse>() {
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

    public  RichMediatorLiveData<CreatePasswordResponse> getLiveCreatePassword(){
        return createPasswordResponseRichMediatorLiveData;
    }

    public void hitCreatePassword(CreatePasswordRequest createPasswordRequest){
        passwordListRepo.hitCreatePassword(createPasswordResponseRichMediatorLiveData,createPasswordRequest);
    }
}
