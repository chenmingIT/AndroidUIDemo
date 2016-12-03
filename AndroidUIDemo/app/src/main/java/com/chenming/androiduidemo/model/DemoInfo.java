package com.chenming.androiduidemo.Model;

import android.app.Activity;

/**
 * Created by ChenMing on 2016/11/7.
 * Demo条目类
 */

public class DemoInfo {
    private final String title ;
    private final Class<? extends Activity> demoClass;

    public DemoInfo(String title, Class<? extends Activity> demoClass) {
        this.title = title;
        this.demoClass = demoClass;
    }

    public Class<? extends Activity> getDemoClass() {
        return demoClass;
    }

    public String getTitle() {
        return title;
    }
}
