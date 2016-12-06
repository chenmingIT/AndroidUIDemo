package com.chenming.androiduidemo.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.Others.CalendarViewDemo;
import com.chenming.androiduidemo.Others.DatePickerDemo;
import com.chenming.androiduidemo.Others.NumberPickerDemo;
import com.chenming.androiduidemo.Others.OtherDemoIndex;
import com.chenming.androiduidemo.Others.ScrollViewDemo;
import com.chenming.androiduidemo.Others.SearchViewDemo;
import com.chenming.androiduidemo.Others.TabHostDemo;
import com.chenming.androiduidemo.Others.TimePickerDemo;
import com.chenming.androiduidemo.Others.ToastDemo;
import com.chenming.androiduidemo.R;

public class MenuDemoIndex extends AppCompatActivity {
    ListView listView ;
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
        setContentView(R.layout.activity_main);

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }

        listView = (ListView)findViewById(R.id.listView) ;
        listView.setAdapter(new DemoListAdapter(MenuDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(MenuDemoIndex.this,DEMOS));
    }
}
