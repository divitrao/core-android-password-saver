package com.example.passwordsaver.adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passwordsaver.R;
import com.example.passwordsaver.apiResponse.passwordList.CredentialList;
import com.example.passwordsaver.databinding.PasswordListRecyclerBinding;

import java.util.ArrayList;

public class PasswordListAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    ArrayList<CredentialList> credentialLists;
    public PasswordListAdaptor(Context context, ArrayList<CredentialList> credentialLists) {
        this.context = context;
        this.credentialLists = credentialLists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        PasswordListRecyclerBinding passwordListRecyclerBinding = PasswordListRecyclerBinding.inflate(layoutInflater,parent,false);

        return  new PasswordListAdaptor.RecommendedPasswordViewHolder(passwordListRecyclerBinding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PasswordListAdaptor.RecommendedPasswordViewHolder latestItem = (PasswordListAdaptor.RecommendedPasswordViewHolder) holder;
        CredentialList recent = credentialLists.get(position);
        latestItem.bind(recent);

    }

    @Override
    public int getItemCount() {
        return credentialLists.size();
    }

    public class  RecommendedPasswordViewHolder extends RecyclerView.ViewHolder{
        PasswordListRecyclerBinding passwordListRecyclerBinding;
        public RecommendedPasswordViewHolder(PasswordListRecyclerBinding passwordListRecyclerBinding) {
            super(passwordListRecyclerBinding.getRoot());
            this.passwordListRecyclerBinding = passwordListRecyclerBinding;
        }

        public  void bind(CredentialList obj){
            passwordListRecyclerBinding.websiteName.setText(obj.getWebsite());
            passwordListRecyclerBinding.webisteImage.setImageResource(R.drawable.add_pass_button);
        }
    }
}
