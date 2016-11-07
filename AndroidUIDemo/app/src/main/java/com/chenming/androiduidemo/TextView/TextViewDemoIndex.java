package com.chenming.androiduidemo.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.MainActivity;
import com.chenming.androiduidemo.R;
import com.chenming.androiduidemo.model.DemoInfo;
import com.chenming.androiduidemo.model.DemoItemClickListener;
import com.chenming.androiduidemo.model.DemoListAdapter;

public class TextViewDemoIndex extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("TextView",TextViewDemo.class),
            new DemoInfo("CheckedTextView",CheckedTextViewDemo.class),
            new DemoInfo("AdapterView及其子类",MainActivity.class)
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
        listView.setAdapter(new DemoListAdapter(TextViewDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(TextViewDemoIndex.this,DEMOS));
    }
}
