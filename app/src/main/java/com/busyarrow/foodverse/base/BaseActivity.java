package com.busyarrow.foodverse.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    protected abstract int layoutRes();
    protected abstract AppCompatActivity currentActivity();
    protected abstract int layoutId();
    private static AppCompatActivity currentActivity = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        setupUi(findViewById(layoutId()));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            Log.d(TAG, "onCreate: activity is " + currentActivity());
            currentActivity = currentActivity();
        }catch (Exception e) {
            Log.d(TAG, "onCreate: error " + e.getMessage());
        }
    }

    protected void setupUi(View view) {
        if(!(view instanceof EditText)){
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard();
                    return false;
                }
            });
        }

        if(view instanceof ViewGroup) {
            for(int i=0; i<((ViewGroup) view).getChildCount();i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUi(innerView);
            }
        }
    }

    public static void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) currentActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(currentActivity.getCurrentFocus().getWindowToken(), 0);

        View focusedView = currentActivity.getCurrentFocus();
        if(focusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
