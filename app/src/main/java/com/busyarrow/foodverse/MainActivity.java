package com.busyarrow.foodverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.busyarrow.foodverse.activities.SigninActivity;
import com.busyarrow.foodverse.activities.SignupActivity;
import com.busyarrow.foodverse.base.BaseActivity;
import com.busyarrow.foodverse.fragments.DashboardFragment;
import com.busyarrow.foodverse.fragments.LocationSelectFragment;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

//    private Button loginBtn, signUp;
    public static final String PLACES_API_KEY = "AIzaSyCc_g-tRdwR9AFZMK0tfEoRVJM4qZyG3SQ";

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

//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        LocationSelectFragment locationSelectFragment = new LocationSelectFragment();
//        ft.add(R.id.parent_main, locationSelectFragment);
//        ft.commit();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        DashboardFragment dashboardFragment = new DashboardFragment();
        ft.add(R.id.parent_main, dashboardFragment);
        ft.commit();

//        loginBtn = findViewById(R.id.loginBtn);
//        signUp = findViewById(R.id.signupBtn);
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SigninActivity.class);
//                startActivity(intent);
//            }
//        });
//        signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, SignupActivity.class);
//                startActivity(i);
//            }
//        });

    }
}