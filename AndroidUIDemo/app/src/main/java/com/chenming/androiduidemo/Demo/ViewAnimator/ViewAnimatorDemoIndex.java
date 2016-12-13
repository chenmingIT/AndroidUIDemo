package com.chenming.androiduidemo.Demo.ViewAnimator;


import android.os.Bundle;
import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.Model.DemoInfo;

public class ViewAnimatorDemoIndex extends DemoIndexActivity {

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
        SetData(this,DEMOS);
    }
}
