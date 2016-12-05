package com.chenming.androiduidemo.Others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.ProgressBar.ProgressBarDemo;
import com.chenming.androiduidemo.ProgressBar.ProgressBarDemoIndex;
import com.chenming.androiduidemo.ProgressBar.RatingBarDemo;
import com.chenming.androiduidemo.ProgressBar.SeekBarDemo;
import com.chenming.androiduidemo.R;

public class OtherDemoIndex extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ToastDemo 提示信息框",ToastDemo.class)
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
        listView.setAdapter(new DemoListAdapter(OtherDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(OtherDemoIndex.this,DEMOS));
    }
}
