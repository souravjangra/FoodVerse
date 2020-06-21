package com.busyarrow.foodverse.networking;

import com.busyarrow.foodverse.models.request.LoginRequest;
import com.busyarrow.foodverse.models.response.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/auth/signin")
    Call<BaseResponse> loginRequest(@Body LoginRequest loginRequest);
}
