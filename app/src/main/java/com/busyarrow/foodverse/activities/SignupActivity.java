package com.busyarrow.foodverse.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.busyarrow.foodverse.R;
import com.busyarrow.foodverse.base.BaseActivity;

public class SignupActivity extends BaseActivity {

    private Button signUp;

    @Override
    protected int layoutRes() {
        return R.layout.activity_signup;
    }

    @Override
    protected AppCompatActivity currentActivity() {
        return this;
    }

    @Override
    protected int layoutId() {
        return R.id.parent_signup;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(getString(R.string.signup));

    }
}
