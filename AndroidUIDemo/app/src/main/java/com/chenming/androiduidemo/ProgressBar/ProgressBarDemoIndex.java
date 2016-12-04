package com.chenming.androiduidemo.ProgressBar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.R;
import com.chenming.androiduidemo.TextView.ButtonDemo;
import com.chenming.androiduidemo.TextView.CheckedTextViewDemo;
import com.chenming.androiduidemo.TextView.ChronometerDemo;
import com.chenming.androiduidemo.TextView.EditTextDemo;
import com.chenming.androiduidemo.TextView.TextClockDemo;
import com.chenming.androiduidemo.TextView.TextViewDemo;
import com.chenming.androiduidemo.TextView.TextViewDemoIndex;

public class ProgressBarDemoIndex extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ProgressBar 进度条",ProgressBarDemo.class),
            new DemoInfo("SeekBar 拖动条",SeekBarDemo.class),
            new DemoInfo("RatingBar 星级评价",RatingBarDemo.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }

        listView = (ListView)findViewById(R.id.listView) ;
        listView.setAdapter(new DemoListAdapter(ProgressBarDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(ProgressBarDemoIndex.this,DEMOS));
    }
}
