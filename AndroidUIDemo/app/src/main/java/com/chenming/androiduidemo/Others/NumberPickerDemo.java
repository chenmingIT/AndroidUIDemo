package com.chenming.androiduidemo.Others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Scroller;
import android.widget.Toast;

import com.chenming.androiduidemo.R;

public class NumberPickerDemo extends AppCompatActivity {
    NumberPicker np1, np2;
    // 定义最低价格、最高价格的初始值
    int minPrice = 25, maxPrice = 75;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker_demo);

        Intent intent = getIntent();
        if (intent.hasExtra("title")) {
            setTitle(intent.getExtras().getString("title"));
        }


        np1 = (NumberPicker) findViewById(R.id.np1);
        // 设置np1的最小值和最大值
        np1.setMinValue(10);
        np1.setMaxValue(50);
        // 设置np1的当前值
        np1.setValue(minPrice);
        /*np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            // 当NumberPicker的值发生改变时，将会激发该方法
            @Override
            public void onValueChange(NumberPicker picker,
                                      int oldVal, int newVal)
            {
                minPrice = newVal;
                showSelectedPrice();
            }
        });*/
        np1.setOnScrollListener(new NumberPicker.OnScrollListener() {
            //SCROLL_STATE_TOUCH_SCROLL：用户按下去然后滑动。
            //SCROLL_STATE_FLING： 相当于是SCROLL_STATE_TOUCH_SCROLL的后续滑动操作。
            //SCROLL_STATE_IDLE： NumberPicker不在滚动。
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE){
                    minPrice = view.getValue();
                    showSelectedPrice();
                }
            }
        });
        np2 = (NumberPicker) findViewById(R.id.np2);
        // 设置np2的最小值和最大值
        np2.setMinValue(60);
        np2.setMaxValue(100);
        // 设置np2的当前值
        np2.setValue(maxPrice);
        /*np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            // 当NumberPicker的值发生改变时，将会激发该方法
            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal)
            {
                maxPrice = newVal;
                showSelectedPrice();
            }
        });*/
        np2.setOnScrollListener(new NumberPicker.OnScrollListener() {
            //SCROLL_STATE_TOUCH_SCROLL：用户按下去然后滑动。
            //SCROLL_STATE_FLING： 相当于是SCROLL_STATE_TOUCH_SCROLL的后续滑动操作。
            //SCROLL_STATE_IDLE： NumberPicker不在滚动。
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE){
                    maxPrice = view.getValue();
                    showSelectedPrice();
                }
            }
        });
    }
    private void showSelectedPrice()
    {
        Toast.makeText(this, "您选择最低价格为：" + minPrice
                + ",最高价格为：" + maxPrice, Toast.LENGTH_SHORT)
                .show();
    }
}

