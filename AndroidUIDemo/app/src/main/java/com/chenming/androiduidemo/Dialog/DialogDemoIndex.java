package com.chenming.androiduidemo.Dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.ImageView.ImageButtonDemo;
import com.chenming.androiduidemo.ImageView.ImageViewDemo;
import com.chenming.androiduidemo.ImageView.ImageViewDemoIndex;
import com.chenming.androiduidemo.ImageView.QuickContactBadgeDemo;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.R;

public class DialogDemoIndex extends AppCompatActivity {
    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("AlertDialog 各类对话框",AlertDialogDemo.class)
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
        listView.setAdapter(new DemoListAdapter(DialogDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(DialogDemoIndex.this,DEMOS));
    }
}
