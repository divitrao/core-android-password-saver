package com.example.passwordsaver.base;
import android.util.Log;

import com.example.passwordsaver.models.CommonResponse;
import com.example.passwordsaver.models.FailureResponse;
import com.google.gson.Gson;
//import com.paradisebiryani.foodcourt.model.FailureResponse;
//import com.paradisebiryani.foodcourt.model.commonresponse.CommonResponse;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NetworkCallback<T> implements Callback<T> {
    public static final int AUTH_FAILED = 99;
    public static final int NO_INTERNET = 9;
    public static final int LOW_PRIORITY_FAILURES = 409;
    public static final int SESSION_EXPIRED_RESPONSE_CODE = 401;

    public abstract void onSuccess(T t);

    public abstract void onFailure(FailureResponse failureResponse);

    public abstract void onError(Throwable t);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            System.out.println(new Gson().toJson(response.body()));
            onSuccess(response.body());

        } else {

            Log.v("onSuccess","onSuccess 2"+response);
            Log.d("ggggg",response.message());
            FailureResponse failureErrorBody = getFailureErrorBody(call.request().url().url().getFile(), response);
            onFailure(failureErrorBody);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof SocketTimeoutException || t instanceof UnknownHostException) {
            FailureResponse failureResponseForNoNetwork = getFailureResponseForNoNetwork();
            onFailure(failureResponseForNoNetwork);
        } else {
            onError(t);
        }
    }

    private FailureResponse getFailureResponseForNoNetwork() {
        FailureResponse failureResponse = new FailureResponse();
        failureResponse.setErrorMessage("No Network");
        failureResponse.setErrorCode(NO_INTERNET);
        return failureResponse;
    }

    /**
     * Create your custom failure response out of server response
     * Also save Url for any further use
     */
    private FailureResponse getFailureErrorBody(String url, Response<T> errorBody) {
        FailureResponse failureResponse = new FailureResponse();
        if (errorBody.code() == 500) {
            failureResponse.setErrorCode(errorBody.code());
            failureResponse.setErrorMessage(errorBody.message());
            return failureResponse;
        }else if (errorBody.code() == 503) {
            failureResponse.setErrorCode(errorBody.code());
            failureResponse.setErrorMessage(errorBody.message());
            return failureResponse;
        }
        else if(errorBody.code()==400){
            FailureResponse failureResponse1 = null ;
            try{
                failureResponse1 = new Gson().fromJson(errorBody.errorBody().string(),FailureResponse.class);
                if(failureResponse1!=null){
                    failureResponse.setErrorCode(failureResponse1.getErrorCode());
                    failureResponse.setErrorMessage(failureResponse1.getErrorMessage());

                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return failureResponse;
        }


        else {
            CommonResponse commonResponse = null;
            try {
                commonResponse = new Gson().fromJson(errorBody.errorBody().string(), CommonResponse.class);
                if(commonResponse!=null && commonResponse.getCODE()!=null) {
                    failureResponse.setErrorMessage(commonResponse.getMESSAGE());
                    failureResponse.setErrorCode(commonResponse.getCODE());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return failureResponse;
        }
    }
}
