package com.chenming.androiduidemo.Demo.ProgressBar;


import android.os.Bundle;
import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.Model.DemoInfo;

public class ProgressBarDemoIndex extends DemoIndexActivity {

    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ProgressBar 进度条",ProgressBarDemo.class),
            new DemoInfo("SeekBar 拖动条",SeekBarDemo.class),
            new DemoInfo("RatingBar 星级评价",RatingBarDemo.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetData(this,DEMOS);
    }
}
