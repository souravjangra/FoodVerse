package com.busyarrow.foodverse.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.busyarrow.foodverse.R;
import com.busyarrow.foodverse.base.BaseActivity;
import com.busyarrow.foodverse.utils.CustomTextWatcher;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends BaseActivity {

    private Button signUp;
    private EditText emailEt, passEt, confirmPassEt, phoneNoEt;
    private TextInputLayout emailTextInput, passTextInput, confirmPassTextInput, phoneTextInput;

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
        emailEt = findViewById(R.id.emailEt);
        passEt = findViewById(R.id.passEt);
        confirmPassEt = findViewById(R.id.confirmPassEt);
        phoneNoEt = findViewById(R.id.phoneEt);

        emailTextInput = findViewById(R.id.email);
        passTextInput = findViewById(R.id.password);
        confirmPassTextInput = findViewById(R.id.confirmPassword);
        phoneTextInput = findViewById(R.id.mobileNumber);

        signUp = findViewById(R.id.loginBtn2);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        refreshEditTexts();

        SpannableString ss = new SpannableString("Already having an Account? Signin");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpan, 27, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView signin_linkTV = findViewById(R.id.signin_link);
        signin_linkTV.setText(ss);
        signin_linkTV.setMovementMethod(LinkMovementMethod.getInstance());
        signin_linkTV.setHighlightColor(Color.TRANSPARENT);

    }

    public void signup() {
        validateInputs();
    }

    private void refreshEditTexts() {
        emailTextInput.getEditText().addTextChangedListener(new CustomTextWatcher(emailTextInput));
        passTextInput.getEditText().addTextChangedListener(new CustomTextWatcher(passTextInput));
        confirmPassTextInput.getEditText().addTextChangedListener(new CustomTextWatcher(confirmPassTextInput));
        phoneTextInput.getEditText().addTextChangedListener(new CustomTextWatcher(phoneTextInput));
    }

    private Boolean validateInputs() {
        Boolean valid = false;
        String email = emailEt.getText().toString();
        String password = passEt.getText().toString();
        String confirmPass = confirmPassEt.getText().toString();
        String phone = phoneNoEt.getText().toString();

        if(email.equals("")){
            emailTextInput.setErrorEnabled(true);
            emailTextInput.setError("Email cannot be empty.");
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTextInput.setErrorEnabled(true);
            emailTextInput.setError("Enter a valid email id.");
        } else if(password.equals("")) {
            passTextInput.setErrorEnabled(true);
            passTextInput.setError("Password cannot be empty");
        } else if(!confirmPass.equals(password)) {
            confirmPassTextInput.setErrorEnabled(true);
            confirmPassTextInput.setError("Confirm password do not match.");
        } else if(phone.equals("")) {
            phoneTextInput.setErrorEnabled(true);
            phoneTextInput.setError("Phone number cannot be empty.");
        } else {
            valid = true;
        }
        return valid;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                this.finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
