package com.example.passwordsaver.uiActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.passwordsaver.R;
import com.example.passwordsaver.adaptor.PasswordListAdaptor;
import com.example.passwordsaver.apiResponse.createPassword.CreatePasswordResponse;
import com.example.passwordsaver.apiResponse.passwordList.CredentialList;
import com.example.passwordsaver.apiResponse.passwordList.PasswordListResponse;
import com.example.passwordsaver.base.BaseActivity;
import com.example.passwordsaver.databinding.ActivityPasswordListBinding;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.repo.PasswordListRepo;
import com.example.passwordsaver.viewModels.CreatePassword.CreatePasswordViewModel;
import com.example.passwordsaver.viewModels.PasswordList.PasswordListViewModel;

import java.util.ArrayList;

public class PasswordList extends BaseActivity {

    private PasswordListViewModel passwordListViewModel;

    private ActivityPasswordListBinding binding;

    private ArrayList<CredentialList> password_list;

    private PasswordListAdaptor passwordListAdaptor;

    private CreatePasswordViewModel createPasswordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_password_list);
//        setContentView(R.layout.activity_password_list);
        setLivedata();
        password_list = new ArrayList<>();
        setAdaptor();
        passwordListViewModel.hitPasswordList();

        binding.createPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PasswordList.this,CreatePasswordActivity.class));
            }
        });




    }

    public void setLivedata(){
//        createPasswordViewModel = new ViewModelProvider(this).get(CreatePasswordViewModel.class);
//        createPasswordViewModel.setGenericListeners(getErrorObserver(),getFailureResponseObserver());
        passwordListViewModel = new ViewModelProvider(this).get(PasswordListViewModel.class);
        passwordListViewModel.setGenericListeners(getErrorObserver(),getFailureResponseObserver());

        passwordListViewModel.getPasswordListResponseRichMediatorLiveData().observe(this, new Observer<PasswordListResponse>() {
            @Override
            public void onChanged(PasswordListResponse passwordListResponse) {
                password_list.clear();
                passwordListAdaptor.notifyDataSetChanged();
                Log.d("rewrqereqr",passwordListResponse.getData().getCredential_list().get(0).getCredential());
                password_list.addAll(passwordListResponse.getData().getCredential_list());
                binding.recyclerPasswordList.setVisibility(View.VISIBLE);
                passwordListAdaptor.notifyDataSetChanged();
            }
        });

//        createPasswordViewModel.getLiveCreatePassword().observe(this, new Observer<CreatePasswordResponse>() {
//            @Override
//            public void onChanged(CreatePasswordResponse createPasswordResponse) {
//                passwordListViewModel.hitPasswordList();
//            }
//        });


    }

    public void setAdaptor(){
        passwordListAdaptor = new PasswordListAdaptor(this,password_list);
        Log.d("rweqweqwewq", String.valueOf(binding));
        binding.recyclerPasswordList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.recyclerPasswordList.setAdapter(passwordListAdaptor);
    }


    @Override
    public  void  onFailure(FailureResponse failureResponse){
        Toast.makeText(this,failureResponse.getErrorMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        passwordListViewModel.hitPasswordList();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
    }
}