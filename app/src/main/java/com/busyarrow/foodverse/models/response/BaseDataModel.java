package com.busyarrow.foodverse.models.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseDataModel {

    @SerializedName("id")
    public int id;
    @SerializedName("email")
    public String email;
    @SerializedName("roles")
    public ArrayList<String> roles;
    @SerializedName("accessToken")
    public String accessToken;
    @SerializedName("phoneNo")
    public String phoneNo;

    public BaseDataModel(int id, String email, ArrayList<String> roles, String accessToken, String phoneNo) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.accessToken = accessToken;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
