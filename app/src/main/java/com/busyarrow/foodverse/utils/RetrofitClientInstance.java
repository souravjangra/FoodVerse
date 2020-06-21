package com.busyarrow.foodverse.utils;

import com.busyarrow.foodverse.networking.BaseUrl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    public static Retrofit retrofit = null;

    public Retrofit getRetrofitClientInstance() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL_DEV)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
