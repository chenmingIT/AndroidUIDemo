package com.chenming.androiduidemo.Demo.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.R;

public class MenuDemoIndex extends DemoIndexActivity {

    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("MenuDemo 基本菜单",MenuDemo.class),
            new DemoInfo("ActivityMenu 设置关联跳转",ActivityMenuDemo.class),
            new DemoInfo("ContextMenu(不是很懂在干嘛) ",ContextMenuDemo.class),
            new DemoInfo("MenuRes 为控件注册上下文菜单",MenuResDemo.class),
            new DemoInfo("PopupMenu 弹出式菜单",PopupMenuDemo.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetData(this,DEMOS);
    }
}
