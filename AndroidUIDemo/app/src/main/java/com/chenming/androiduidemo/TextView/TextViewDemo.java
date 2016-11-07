package com.chenming.androiduidemo.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.chenming.androiduidemo.R;

public class TextViewDemo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_demo);

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }


    }
}
