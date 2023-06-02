package com.example.passwordsaver.uiActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.passwordsaver.R;
import com.example.passwordsaver.apiRequest.CreatePasswordRequest;
import com.example.passwordsaver.apiResponse.createPassword.CreatePasswordResponse;
import com.example.passwordsaver.base.BaseActivity;
import com.example.passwordsaver.databinding.ActivityCreatePasswordBinding;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.viewModels.CreatePassword.CreatePasswordViewModel;

public class CreatePasswordActivity extends BaseActivity {

    private ActivityCreatePasswordBinding binding;

    private CreatePasswordViewModel createPasswordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_create_password);
        setLiveData();
        binding.buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreatePasswordRequest createPasswordRequest = new CreatePasswordRequest();

                createPasswordRequest.setCredential(String.valueOf(binding.usernameTextfield.getText()));
                createPasswordRequest.setWebsite(String.valueOf(binding.webisteName.getText()));
                createPasswordRequest.setPassword1(String.valueOf(binding.editTextTextPassword.getText()));
                createPasswordRequest.setPassword2(String.valueOf(binding.editTextTextPasswordReenter.getText()));
                createPasswordViewModel.hitCreatePassword(createPasswordRequest);
            }
        });

    }

    public  void  setLiveData(){
        createPasswordViewModel = new ViewModelProvider(this).get(CreatePasswordViewModel.class);
        createPasswordViewModel.setGenericListeners(getErrorObserver(),getFailureResponseObserver());

        createPasswordViewModel.getLiveCreatePassword().observe(this, new Observer<CreatePasswordResponse>() {
            @Override
            public void onChanged(CreatePasswordResponse createPasswordResponse) {
                finish();
            }
        });
    }

    @Override
    public  void  onFailure(FailureResponse failureResponse){
        Toast.makeText(this,failureResponse.getErrorMessage(),Toast.LENGTH_LONG).show();
    }
}