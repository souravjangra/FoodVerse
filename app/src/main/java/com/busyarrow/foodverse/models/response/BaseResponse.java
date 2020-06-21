package com.busyarrow.foodverse.models.response;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("success")
    public Boolean success;
    @SerializedName("message")
    public String message;
    @SerializedName("accessToken")
    public String accessToken;
    @SerializedName("data")
    public BaseDataModel data;

    public BaseResponse(Boolean success, String message, String accessToken, BaseDataModel data) {
        this.success = success;
        this.message = message;
        this.accessToken = accessToken;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
