package com.example.passwordsaver.uiActivity;



import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.passwordsaver.R;
import com.example.passwordsaver.apiResponse.passwordList.CredentialList;
import com.example.passwordsaver.base.BaseActivity;
import com.example.passwordsaver.databinding.ActivityCredentialDetailBinding;
import com.example.passwordsaver.repo.WebsiteLogoRepo;
import com.google.gson.Gson;

public class CredentialDetailActivity extends BaseActivity {

    private ActivityCredentialDetailBinding binding;
    private WebsiteLogoRepo websiteLogoRepo = new WebsiteLogoRepo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_credential_detail);
        Gson gson = new Gson();
        String credentialList = getIntent().getStringExtra("credential_detail");
        CredentialList credential_list = gson.fromJson(credentialList,CredentialList.class);
        binding.usernameText.setText(credential_list.getCredential());
        binding.passwordText.setText(credential_list.getPassword());
        binding.websiteText.setText(credential_list.getWebsite());
        websiteLogoRepo.fetchLogo(credential_list.getWebsite(),binding.imageView,this);

    }
}