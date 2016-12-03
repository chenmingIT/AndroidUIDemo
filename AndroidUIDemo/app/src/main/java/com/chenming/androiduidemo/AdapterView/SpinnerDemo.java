package com.chenming.androiduidemo.AdapterView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.chenming.androiduidemo.R;

public class SpinnerDemo extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }

        // 获取界面布局文件中的Spinner组件
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] arr = { "孙悟空", "猪八戒", "唐僧" };
        // 创建ArrayAdapter对象
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arr);
        // 为Spinner设置Adapter
        spinner.setAdapter(adapter);
    }
}
