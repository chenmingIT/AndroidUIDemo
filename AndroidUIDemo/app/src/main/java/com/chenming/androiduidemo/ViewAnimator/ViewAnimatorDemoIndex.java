package com.chenming.androiduidemo.ViewAnimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.R;

public class ViewAnimatorDemoIndex extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ViewSwitcher 仿桌面多屏",ViewSwitcherDemo.class),
            new DemoInfo("ImageSwitcher 图片切换器",ImageSwitcherDemo.class),
            new DemoInfo("TextSwitcher 文本切换器",TextSwitcherDemo.class),
            new DemoInfo("ViewFlipper 自动播放",ViewFlipperDemo.class)
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
        listView.setAdapter(new DemoListAdapter(ViewAnimatorDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(ViewAnimatorDemoIndex.this,DEMOS));
    }
}
