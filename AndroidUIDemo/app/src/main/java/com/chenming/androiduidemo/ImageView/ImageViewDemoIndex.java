package com.chenming.androiduidemo.ImageView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.chenming.androiduidemo.R;
import com.chenming.androiduidemo.model.DemoInfo;
import com.chenming.androiduidemo.model.DemoItemClickListener;
import com.chenming.androiduidemo.model.DemoListAdapter;

public class ImageViewDemoIndex extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ImageView 图片显示器",ImageViewDemo.class),
            new DemoInfo("ImageButton 强化的图片按钮",ImageButtonDemo.class),
            new DemoInfo("QuickContactBadge 关联指定联系人",QuickContactBadgeDemo.class)
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
        listView.setAdapter(new DemoListAdapter(ImageViewDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(ImageViewDemoIndex.this,DEMOS));
    }
}
