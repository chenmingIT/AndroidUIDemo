package com.chenming.androiduidemo.Demo.ImageView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.R;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;

public class ImageViewDemoIndex extends DemoIndexActivity {

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
        SetData(this,DEMOS);
    }
}
