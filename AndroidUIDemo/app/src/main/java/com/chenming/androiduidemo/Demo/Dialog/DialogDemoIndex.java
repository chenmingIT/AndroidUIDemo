package com.chenming.androiduidemo.Demo.Dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.BaseActivity.DemoIndexActivity;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.R;

public class DialogDemoIndex extends DemoIndexActivity {

    /**
     *title及其对应要跳转的class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo("AlertDialog 各类对话框",AlertDialogDemo.class),
            new DemoInfo("PopupWindow 弹出框",PopupWindowDemo.class),
            new DemoInfo("DateDialog 日期选择弹出框",DateDialogDemo.class),
            new DemoInfo("ProgressDialog 进度情况弹出框",ProgressDialogDemo.class)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SetData(this,DEMOS);
    }
}
