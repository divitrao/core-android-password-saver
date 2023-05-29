package com.example.passwordsaver.uiActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.passwordsaver.R;
import com.example.passwordsaver.apiRequest.LoginRequest;
import com.example.passwordsaver.apiResponse.LoginResponse;
import com.example.passwordsaver.base.BaseActivity;
import com.example.passwordsaver.data.DataManager;
import com.example.passwordsaver.databinding.ActivityLoginBinding;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.viewModels.Login.LoginViewModel;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        setLiveData();
        Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
//        loginViewModel.setGenericListeners(getErrorObserver(),getFailureResponseObserver());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setUsername(String.valueOf(binding.loginUsername.getText()));
                loginRequest.setPassword(String.valueOf(binding.editTextTextPassword.getText()));
                loginViewModel.hitLogApi(loginRequest);

            }
        });

        binding.navigateToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("rrr","opopop");
                startActivity(register);

            }
        });

    }

    private  void setLiveData(){
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.setGenericListeners(getErrorObserver(),getFailureResponseObserver());

        loginViewModel.liveDataLoginApi().observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {
                DataManager.getInstance().setAccessToken(loginResponse.getAccess());
                DataManager.getInstance().setRefreshToken(loginResponse.getRefresh());
                startActivity(new Intent(LoginActivity.this, PasswordList.class));
                finish();
            }
        });
    }

    @Override
    public  void  onFailure(FailureResponse failureResponse){
        Toast.makeText(this,failureResponse.getErrorMessage(),Toast.LENGTH_LONG).show();
    }
}