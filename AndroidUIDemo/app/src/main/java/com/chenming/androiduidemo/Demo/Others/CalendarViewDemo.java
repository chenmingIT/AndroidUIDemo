package com.chenming.androiduidemo.Demo.Others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

public class CalendarViewDemo  extends DemoActivity {

    private CalendarView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view_demo);


        cv = (CalendarView)findViewById(R.id.calendarView);
        // 为CalendarView组件的日期改变事件添加事件监听器
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth)
            {
                // 使用Toast显示用户选择的日期
                //月份是0-11
                Toast.makeText(CalendarViewDemo.this,
                        "你生日是" + year + "年" + (month+1) + "月"
                                + dayOfMonth + "日",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
