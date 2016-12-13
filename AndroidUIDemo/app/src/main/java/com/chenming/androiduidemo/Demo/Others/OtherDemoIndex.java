package com.chenming.androiduidemo.Demo.Others;


import android.os.Bundle;

import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.Model.DemoInfo;

public class OtherDemoIndex extends DemoIndexActivity {

    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ToastDemo 提示信息框",ToastDemo.class),
            new DemoInfo("CalendarView 日历视图",CalendarViewDemo.class),
            new DemoInfo("DatePicker 日期选择",DatePickerDemo.class),
            new DemoInfo("TimePicker 时间选择",TimePickerDemo.class),
            new DemoInfo("NumberPicker 数值选择",NumberPickerDemo.class),
            new DemoInfo("SearchView 搜索框(待完善)",SearchViewDemo.class),
            new DemoInfo("TabHost 选项卡(待完善)",TabHostDemo.class),
            new DemoInfo("ScrollView 滚动视图",ScrollViewDemo.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SetData(this,DEMOS);
    }
}
