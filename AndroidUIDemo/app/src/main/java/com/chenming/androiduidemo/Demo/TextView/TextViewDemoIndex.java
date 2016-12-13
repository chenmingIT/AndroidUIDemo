package com.chenming.androiduidemo.Demo.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.R;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;

public class TextViewDemoIndex extends DemoIndexActivity {

    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("TextView 文本框",TextViewDemo.class),
            new DemoInfo("CheckedTextView 勾选文本框",CheckedTextViewDemo.class),
            new DemoInfo("EditText 编辑框",EditTextDemo.class),
            new DemoInfo("Button 按钮",ButtonDemo.class),
            new DemoInfo("Chronometer 计时器",ChronometerDemo.class),
            new DemoInfo("TextClock 时间显示",TextClockDemo.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetData(this,DEMOS);
    }
}
