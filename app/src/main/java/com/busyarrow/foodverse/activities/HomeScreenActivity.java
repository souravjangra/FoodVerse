package com.busyarrow.foodverse.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.busyarrow.foodverse.base.BaseActivity;

public class HomeScreenActivity extends BaseActivity {
    @Override
    protected int layoutRes() {
        return 0;
    }

    @Override
    protected AppCompatActivity currentActivity() {
        return null;
    }

    @Override
    protected int layoutId() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
