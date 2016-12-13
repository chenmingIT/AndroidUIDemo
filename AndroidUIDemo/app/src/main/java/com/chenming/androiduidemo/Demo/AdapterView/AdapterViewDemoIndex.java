package com.chenming.androiduidemo.Demo.AdapterView;

import android.os.Bundle;

import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.Model.DemoInfo;

public class AdapterViewDemoIndex extends DemoIndexActivity {

    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ListView 列表",ListViewDemo.class),
            new DemoInfo("用Adapter创建ListView",AdapterListViewDemo.class),
            new DemoInfo("GridView 网络视图",GridViewDemo.class),
            new DemoInfo("ExpandableListView 可展开的列表",ExpandableListViewDemo.class),
            new DemoInfo("Spinner 可选择列表", SpinnerDemo.class),
            new DemoInfo("AdapterViewFlipper 自带图片播放", AdapterViewFlipperDemo.class),
            new DemoInfo("StackViewDemo 图片显示叠加",StackViewDemo.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetData(this,DEMOS);

    }
}
