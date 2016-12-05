package com.chenming.androiduidemo.Others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chenming.androiduidemo.R;

public class ScrollViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_demo);
        Intent intent = getIntent();
        if (intent.hasExtra("title")) {
            setTitle(intent.getExtras().getString("title"));
        }

    }

}