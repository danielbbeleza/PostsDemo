package com.example.android.postsdemo.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.postsdemo.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_layout_home_activity);

        if(fragment == null){
            fragment = new HomeFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.frame_layout_home_activity, fragment)
                    .commit();
        }
    }
}
