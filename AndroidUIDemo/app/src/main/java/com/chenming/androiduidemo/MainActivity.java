package com.chenming.androiduidemo;

import android.os.Bundle;
import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.Demo.AdapterView.AdapterViewDemoIndex;
import com.chenming.androiduidemo.Demo.Dialog.DialogDemoIndex;
import com.chenming.androiduidemo.Demo.ImageView.ImageViewDemoIndex;
import com.chenming.androiduidemo.Demo.Menu.MenuDemoIndex;
import com.chenming.androiduidemo.Demo.Others.OtherDemoIndex;
import com.chenming.androiduidemo.Demo.ProgressBar.ProgressBarDemoIndex;
import com.chenming.androiduidemo.Demo.TextView.TextViewDemoIndex;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Demo.ViewAnimator.ViewAnimatorDemoIndex;

public class MainActivity extends DemoIndexActivity {

    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("TextView及其子类",TextViewDemoIndex.class),
            new DemoInfo("ImageView及其子类",ImageViewDemoIndex.class),
            new DemoInfo("AdapterView及其子类",AdapterViewDemoIndex.class),
            new DemoInfo("ProgressBar及其子类",ProgressBarDemoIndex.class),
            new DemoInfo("ViewAnimator及其子类", ViewAnimatorDemoIndex.class),
            new DemoInfo("各种杂件组件", OtherDemoIndex.class),
            new DemoInfo("Dialog 对话框", DialogDemoIndex.class),
            new DemoInfo("Menu 菜单", MenuDemoIndex.class)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetData(this,DEMOS);
    }
}


