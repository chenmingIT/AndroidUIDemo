package com.chenming.androiduidemo.Demo.Others;

import android.content.Intent;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

public class TimePickerDemo  extends DemoActivity {

    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_demo);

        TimePicker timePicker = (TimePicker)
                findViewById(R.id.timePicker);
        // 获取当前的年、月、日、小时、分钟
        Calendar c = Calendar.getInstance();

        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        // 初始化DatePicker组件，初始化时指定监听器
        timePicker.setEnabled(true);
        // 为TimePicker指定监听器
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener()
        {
            @Override
            public void onTimeChanged(TimePicker view
                    , int hourOfDay, int minute)
            {
                TimePickerDemo.this.hour = hourOfDay;
                TimePickerDemo.this.minute = minute;
                // 显示当前日期、时间
                showDate(hour, minute);
            }
        });
    }
    // 定义在EditText中显示当前日期、时间的方法
    private void showDate(int hour, int minute)
    {
        String str = hour + "时" + minute + "分";

        Toast.makeText(this,str,Toast.LENGTH_SHORT).show(); ;
    }
}

