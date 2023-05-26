package com.example.passwordsaver.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.passwordsaver.data.DataManager;
import com.example.passwordsaver.models.FailureResponse;

public abstract class BaseActivity extends AppCompatActivity {

    private Observer<Throwable> errorObserver;
    private Observer<FailureResponse> failureResponseObserver;

    private static Context context;

    public Observer<Throwable> getErrorObserver() {
        return errorObserver;
    }

    public Observer<FailureResponse> getFailureResponseObserver() {
        return failureResponseObserver;
    }

//    @Override
    protected   void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        Log.d("ttttttttttt","=============");
        DataManager dataManager = DataManager.init(context);
        dataManager.initApiManager();
        initObservers();

    }

    private  void initObservers(){
        errorObserver = new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                onErrorOccurred(throwable);
            }
        };

        failureResponseObserver = new Observer<FailureResponse>() {
            @Override
            public void onChanged(FailureResponse failureResponse) {
                Log.d("uuuuuuuuuuuu", failureResponse.getErrorMessage());
                onFailure(failureResponse);
            }
        };
    }

    protected void onFailure(FailureResponse failureResponse){

    }
    protected void onErrorOccurred(Throwable throwable) {
        Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_LONG).show();
    }
}
