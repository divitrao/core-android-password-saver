package com.example.passwordsaver.uiActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.passwordsaver.R;
import com.example.passwordsaver.base.BaseActivity;
import com.example.passwordsaver.databinding.ActivityLoginBinding;
import com.example.passwordsaver.viewModels.Login.LoginViewModel;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
//        loginViewModel.setGenericListeners(getErrorObserver(),getFailureResponseObserver());
        binding.navigateToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("rrr","opopop");
                startActivity(register);

            }
        });

    }
}