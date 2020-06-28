package com.busyarrow.foodverse.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class CustomTextWatcher implements TextWatcher {

    private TextInputLayout view;

    public CustomTextWatcher(TextInputLayout view) {
        this.view = view;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        view.setErrorEnabled(false);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
