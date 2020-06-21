package com.busyarrow.foodverse.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.busyarrow.foodverse.R;
import com.busyarrow.foodverse.base.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;


public class SigninActivity extends BaseActivity {

    private static final String TAG = "SigninActivity";
    
    private TextInputEditText emailEt, passEt;
    private String email, pass;
    private Button loginBtn;

    @Override
    protected int layoutRes() {
        return R.layout.activity_signin;
    }

    @Override
    protected AppCompatActivity currentActivity() {
        return this;
    }

    @Override
    protected int layoutId() {
        return R.id.parent_signin;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(getString(R.string.login));
        
        emailEt = findViewById(R.id.emailEt);
        passEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn2);
        
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        
    }
    
    private void login() {
        email = emailEt.getText().toString();
        pass = passEt.getText().toString();
        validateFields(email, pass);
    }
    
    public void validateFields(String email, String pass) {
        if(email.equals("")) {
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
