package com.chenming.androiduidemo.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.chenming.androiduidemo.MainActivity;
import com.chenming.androiduidemo.R;

public class ActivityMenuDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // -------------向menu中添加子菜单-------------
        SubMenu prog = menu.addSubMenu("启动程序");
        // 设置菜单头的图标
        prog.setHeaderIcon(R.drawable.tools);
        // 设置菜单头的标题
        prog.setHeaderTitle("选择您要启动的程序");
        // 添加菜单项
        MenuItem item1 = prog.add("上一页");
        MenuItem item2 = prog.add("主页");

        //为菜单项设置关联的Activity
        item1.setIntent(new Intent(this , MenuDemoIndex.class));
        item2.setIntent(new Intent(this , MainActivity.class));


        return super.onCreateOptionsMenu(menu);
    }
}
