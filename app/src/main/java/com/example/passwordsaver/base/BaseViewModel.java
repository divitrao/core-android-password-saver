package com.example.passwordsaver.base;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.passwordsaver.api.ApiManager;
import com.example.passwordsaver.models.FailureResponse;

public abstract class BaseViewModel extends ViewModel {

    protected Observer<Throwable> mErrorObserver;

    protected Observer<FailureResponse> mFailureObserver;
    private ApiManager apiManager;
    public void initApiManager(){
        apiManager = ApiManager.getInstance();
    }
    public void setGenericListeners(Observer<Throwable> errorObserver,
                                    Observer<FailureResponse> failureResponseObserver) {
        this.mErrorObserver = errorObserver;
        this.mFailureObserver = failureResponseObserver;
        initLiveData();
    }

    abstract public void initLiveData();
}
