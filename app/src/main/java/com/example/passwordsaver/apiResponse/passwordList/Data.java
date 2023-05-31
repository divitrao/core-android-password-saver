package com.example.passwordsaver.apiResponse.passwordList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("credential_list")
    @Expose
    private List<CredentialList> credential_list;

//    public Data(List<CredentialList> credential_list) {
//        this.credential_list = credential_list;
//    }

    public List<CredentialList> getCredential_list() {
        return credential_list;
    }

    public void setCredential_list(List<CredentialList> credential_list) {
        this.credential_list = credential_list;
    }
}
