package com.example.passwordsaver.uiActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.passwordsaver.R;
import com.example.passwordsaver.adaptor.PasswordListAdaptor;
import com.example.passwordsaver.apiResponse.passwordList.CredentialList;
import com.example.passwordsaver.apiResponse.passwordList.PasswordListResponse;
import com.example.passwordsaver.base.BaseActivity;
import com.example.passwordsaver.databinding.ActivityPasswordListBinding;
import com.example.passwordsaver.models.FailureResponse;
import com.example.passwordsaver.repo.PasswordListRepo;
import com.example.passwordsaver.viewModels.PasswordList.PasswordListViewModel;

import java.util.ArrayList;

public class PasswordList extends BaseActivity {

    private PasswordListViewModel passwordListViewModel;

    private ActivityPasswordListBinding binding;

    private ArrayList<CredentialList> password_list;

    private PasswordListAdaptor passwordListAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_password_list);
//        setContentView(R.layout.activity_password_list);
        setLivedata();
        password_list = new ArrayList<>();
        setAdaptor();
        passwordListViewModel.hitPasswordList();




    }

    public void setLivedata(){
        passwordListViewModel = new ViewModelProvider(this).get(PasswordListViewModel.class);
        passwordListViewModel.setGenericListeners(getErrorObserver(),getFailureResponseObserver());

        passwordListViewModel.getPasswordListResponseRichMediatorLiveData().observe(this, new Observer<PasswordListResponse>() {
            @Override
            public void onChanged(PasswordListResponse passwordListResponse) {
                Log.d("rewrqereqr",passwordListResponse.getData().getCredential_list().get(0).getCredential());
                password_list.addAll(passwordListResponse.getData().getCredential_list());
                binding.recyclerPasswordList.setVisibility(View.VISIBLE);
                passwordListAdaptor.notifyDataSetChanged();
            }
        });
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
}