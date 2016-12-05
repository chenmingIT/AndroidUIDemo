package com.chenming.androiduidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.AdapterView.AdapterViewDemoIndex;
import com.chenming.androiduidemo.ImageView.ImageViewDemoIndex;
import com.chenming.androiduidemo.Others.OtherDemoIndex;
import com.chenming.androiduidemo.ProgressBar.ProgressBarDemoIndex;
import com.chenming.androiduidemo.TextView.TextViewDemoIndex;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.ViewAnimator.ViewAnimatorDemoIndex;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("TextView及其子类",TextViewDemoIndex.class),
            new DemoInfo("ImageView及其子类",ImageViewDemoIndex.class),
            new DemoInfo("AdapterView及其子类",AdapterViewDemoIndex.class),
            new DemoInfo("ProgressBar及其子类",ProgressBarDemoIndex.class),
            new DemoInfo("ViewAnimator及其子类", ViewAnimatorDemoIndex.class),
            new DemoInfo("各种杂件组件", OtherDemoIndex.class)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView) ;
        listView.setAdapter(new DemoListAdapter(MainActivity.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(MainActivity.this,DEMOS));
    }
}


