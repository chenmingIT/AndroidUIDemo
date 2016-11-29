package com.chenming.androiduidemo.AdapterView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.chenming.androiduidemo.R;
import com.chenming.androiduidemo.model.DemoInfo;
import com.chenming.androiduidemo.model.DemoItemClickListener;
import com.chenming.androiduidemo.model.DemoListAdapter;

public class AdapterViewDemoIndex extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ListView 列表",ListViewDemo.class),
            new DemoInfo("用Adapter创建ListView",AdapterListViewDemo.class)

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
        listView.setAdapter(new DemoListAdapter(AdapterViewDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(AdapterViewDemoIndex.this,DEMOS));
    }
}
