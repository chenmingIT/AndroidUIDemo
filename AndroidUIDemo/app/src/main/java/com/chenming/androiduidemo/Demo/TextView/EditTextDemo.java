package com.chenming.androiduidemo.Demo.TextView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

public class EditTextDemo extends DemoActivity {

    //第一个自动完成文本框
    AutoCompleteTextView autoCompleteTextView ;
    String []str=new String[]{"China","Japan","Korean","Russian","USA","Hong Kong"};

    //第二个自动完成文本框
    AutoCompleteTextView autoCompleteTextView2 ;
    Button searchButton,emptyButton ;
    private ArrayAdapter<String> arr_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_demo);

        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.antoCompleteTextView) ;
        //指定适配器
        autoCompleteTextView.setAdapter(
                new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, str) ) ;


        //保存历史记录
        autoCompleteTextView2 = (AutoCompleteTextView)findViewById(R.id.antoCompleteTextView2) ;
        searchButton = (Button)findViewById(R.id.search) ;
        emptyButton = (Button)findViewById(R.id.empty) ;
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
        emptyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty();
            }
        });
        refreshAdapter();
    }

    /**
     * 更新适配器内容
     */
    private void refreshAdapter(){
        // 获取搜索记录文件内容
        SharedPreferences sp = getSharedPreferences("search_history", Context.MODE_APPEND);
        String history = sp.getString("history", "暂时没有搜索记录");

        // 用逗号分割内容返回数组
        String[] history_arr = history.split(",");


        autoCompleteTextView2.setAdapter(
                new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, history_arr) ) ;

    }

    /**
     * 搜索按钮
     */
    public void search(){
        /**
         * Android平台给我们提供了一个SharedPreferences类，它是一个轻量级的存储类，特别适合用于保存软件配置参数。
         * 使用SharedPreferences保存数据，其背后是用xml文件存放数据，
         * 文件存放在/data/data/<package name>/shared_prefs目录下
         */
        String text = autoCompleteTextView2.getText().toString() ;
        SharedPreferences mysp = getSharedPreferences("search_history", Context.MODE_APPEND) ;
        //getString()两个参数：第一个代表key值 第二个代表如果没有key值返回的东西
        String old_text = mysp.getString("history", "暂时没有搜索记录");
        // 利用StringBuilder.append新增内容，逗号便于读取内容时用逗号拆分开
        StringBuilder builder = new StringBuilder(old_text);
        builder.append(text + ",");

        // 判断搜索内容是否已经存在于历史文件，已存在则不重复添加
        if (!old_text.contains(text + ",")) {
            SharedPreferences.Editor myeditor = mysp.edit();
            myeditor.putString("history", builder.toString());
            myeditor.commit();
            Toast.makeText(this, text + "搜索记录添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, text + "已存在", Toast.LENGTH_SHORT).show();
        }
        //清空自动补充 刷新适配器
        autoCompleteTextView2.setText("");
        refreshAdapter();
    }

    /**
     * 清空搜索记录
     */
    public void empty(){
        /**
         * 调用Context对象的getSharedPreferences()方法获得的SharedPreferences对象可以被同一应用程序下的其他组件共享.
         * 调用Activity对象的getPreferences()方法获得的SharedPreferences对象只能在该Activity中使用.
         */
        //getSharedPreferences两个参数
        //第一个参数是存储时候的名称 search_history 系统自动加上xml
        //第二个参数是打开方式
        SharedPreferences sp = getSharedPreferences("search_history", Context.MODE_APPEND) ;
        SharedPreferences.Editor editor=sp.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this, "搜索记录清除成功", Toast.LENGTH_SHORT).show();
        refreshAdapter();
        //super.onDestroy(); //这个会删掉文件,导致每次清空完第二次就出错（网上的有点问题）
    }
}








