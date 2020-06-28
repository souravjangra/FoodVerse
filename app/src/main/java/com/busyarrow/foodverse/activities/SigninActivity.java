package com.busyarrow.foodverse.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.busyarrow.foodverse.MainActivity;
import com.busyarrow.foodverse.R;
import com.busyarrow.foodverse.base.BaseActivity;
import com.busyarrow.foodverse.models.request.LoginRequest;
import com.busyarrow.foodverse.models.response.BaseResponse;
import com.busyarrow.foodverse.networking.ApiInterface;
import com.busyarrow.foodverse.utils.AndroidUtils;
import com.busyarrow.foodverse.utils.RetrofitClientInstance;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class SigninActivity extends BaseActivity {

    private static final String TAG = "SigninActivity";

    private TextInputLayout emailTextInput, passTextInput;
    private TextInputEditText emailEt, passEt;
    private String email, pass;
    private Button loginBtn;
    private View progressOverlay;

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
        emailTextInput = findViewById(R.id.email);
        passTextInput = findViewById(R.id.password);

        progressOverlay = findViewById(R.id.progress_overlay);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        setupEditText();

        SpannableString ss = new SpannableString("Not having an Account? Signup");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
            }
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, 23, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView signupLink = findViewById(R.id.signup_link);
        signupLink.setText(ss);
        signupLink.setMovementMethod(LinkMovementMethod.getInstance());
        signupLink.setHighlightColor(Color.TRANSPARENT);

        
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupEditText() {
        emailTextInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailTextInput.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passTextInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passTextInput.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    
    private void login() {
        email = emailEt.getText().toString();
        pass = passEt.getText().toString();
        if(validateFields(email, pass)) {
//            AndroidUtils.animateView(progressOverlay, View.VISIBLE, 0.4f, 200);

            LoginRequest loginRequest = new LoginRequest(email, pass);
            ApiInterface apiInterface = RetrofitClientInstance.getRetrofitClientInstance().create(ApiInterface.class);
            Call<BaseResponse> loginResponse = apiInterface.loginRequest(loginRequest);
            loginResponse.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                    Log.d(TAG, "onResponse: " + response.body().data.accessToken);
                }

                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                }
            });

//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    AndroidUtils.animateView(progressOverlay, View.GONE, 0, 200);
//                }
//            },5000);
        }
    }
    
    public Boolean validateFields(String email, String pass) {
        Boolean valid = false;
        if(email.equals("")) {
            emailTextInput.setErrorEnabled(true);
            emailTextInput.setError("Email cannot be empty.");
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTextInput.setErrorEnabled(true);
            emailTextInput.setError("Enter a valid email id.");
        } else if(pass.equals("")) {
            passTextInput.setError("Password cannot be empty.");
        } else {
            valid = true;
        }
        return valid;
    }
}
