package com.chenming.androiduidemo.Others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.ProgressBar.ProgressBarDemo;
import com.chenming.androiduidemo.ProgressBar.ProgressBarDemoIndex;
import com.chenming.androiduidemo.ProgressBar.RatingBarDemo;
import com.chenming.androiduidemo.ProgressBar.SeekBarDemo;
import com.chenming.androiduidemo.R;

public class OtherDemoIndex extends AppCompatActivity {

    ListView listView ;
    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("ToastDemo 提示信息框",ToastDemo.class),
            new DemoInfo("CalendarView 日历视图",CalendarViewDemo.class),
            new DemoInfo("ChooseDate 日期选择(存在问题)",ChooseDateDemo.class),
            new DemoInfo("NumberPicker 数值选择",NumberPickerDemo.class),
            new DemoInfo("SearchView 搜索框(存在问题)",SearchViewDemo.class),
            new DemoInfo("TabHost 选项卡(存在问题)",TabHostDemo.class),
            new DemoInfo("ScrollView 滚动视图",ScrollViewDemo.class)
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
        listView.setAdapter(new DemoListAdapter(OtherDemoIndex.this,DEMOS));
        listView.setOnItemClickListener(new DemoItemClickListener(OtherDemoIndex.this,DEMOS));
    }
}
