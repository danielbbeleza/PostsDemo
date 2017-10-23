package com.example.android.postsdemo.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.android.postsdemo.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(savedInstanceState == null){
            Fragment fragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_detail_activity, fragment)
                    .commit();
        }
    }
}
