package com.chenming.androiduidemo.Others;

import android.content.Intent;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

import com.chenming.androiduidemo.R;

public class DatePickerDemo extends AppCompatActivity {

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_demo);
        Intent intent = getIntent();
        if (intent.hasExtra("title")) {
            setTitle(intent.getExtras().getString("title"));
        }

        DatePicker datePicker = (DatePicker)
                findViewById(R.id.datePicker);

        // 获取当前的年、月、日、小时、分钟
        Calendar c = Calendar.getInstance();

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // 初始化DatePicker组件，初始化时指定监听器
        datePicker.init(year, month, day, new OnDateChangedListener()
        {
            @Override
            public void onDateChanged(DatePicker arg0, int year
                    , int month, int day)
            {
                DatePickerDemo.this.year = year;
                DatePickerDemo.this.month = month;
                DatePickerDemo.this.day = day;
                // 显示当前日期、时间
                showDate(year, month, day);
            }
        });
    }
    // 定义在EditText中显示当前日期、时间的方法
    private void showDate(int year, int month, int day)
    {
        String str = year + "年"
                + (month + 1) + "月" + day + "日  ";

        Toast.makeText(this,str,Toast.LENGTH_SHORT).show(); ;
    }
}

