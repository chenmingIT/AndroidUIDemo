package com.chenming.androiduidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.TextView.TextViewDemoIndex;
import com.chenming.androiduidemo.model.DemoInfo;
import com.chenming.androiduidemo.model.DemoItemClickListener;
import com.chenming.androiduidemo.model.DemoListAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("TextView及其子类",TextViewDemoIndex.class),
            new DemoInfo("ImageView及其子类",MainActivity.class),
            new DemoInfo("AdapterView及其子类",MainActivity.class)
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


