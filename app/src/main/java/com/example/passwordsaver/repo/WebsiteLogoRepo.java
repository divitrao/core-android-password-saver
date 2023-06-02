package com.example.passwordsaver.repo;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.passwordsaver.apiResponse.WebsiteLogo.WebsiteLogoresponse;
import com.example.passwordsaver.base.NetworkCallback;
import com.example.passwordsaver.data.DataManager;
import com.example.passwordsaver.models.FailureResponse;

public class WebsiteLogoRepo {

    public void fetchLogo(String url, ImageView imageView, Context context){
        DataManager.getInstance().fetchLogo(url).enqueue(new NetworkCallback<WebsiteLogoresponse>() {
            @Override
            public void onSuccess(WebsiteLogoresponse websiteLogoresponse) {
                if(websiteLogoresponse.getIconsDataList().size()>0) {
                    Glide.with(context)
                            .load(websiteLogoresponse.getIconsDataList().get(0).getUrl())
                            .centerCrop()
                            .into(imageView);
                }
            }

            @Override
            public void onFailure(FailureResponse failureResponse) {

            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }
}
