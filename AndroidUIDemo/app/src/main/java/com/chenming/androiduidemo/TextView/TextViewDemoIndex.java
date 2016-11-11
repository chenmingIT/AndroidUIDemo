package com.chenming.androiduidemo.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

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
            new DemoInfo("TextView 文本框",TextViewDemo.class),
            new DemoInfo("CheckedTextView 勾选文本框",CheckedTextViewDemo.class),
            new DemoInfo("EditText 编辑框",EditTextDemo.class),
            new DemoInfo("Button 按钮",ButtonDemo.class),
            new DemoInfo("Chronometer 计时器",ChronometerDemo.class),
            new DemoInfo("TextClock 时间显示",TextClockDemo.class)
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
