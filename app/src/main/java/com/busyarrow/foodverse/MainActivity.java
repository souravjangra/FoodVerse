package com.busyarrow.foodverse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.busyarrow.foodverse.activities.SigninActivity;
import com.busyarrow.foodverse.activities.SignupActivity;
import com.busyarrow.foodverse.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button loginBtn, signUp;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected AppCompatActivity currentActivity() {
        return this;
    }

    @Override
    protected int layoutId() {
        return R.id.parent_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        loginBtn = findViewById(R.id.loginBtn);
        signUp = findViewById(R.id.signupBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

    }
}