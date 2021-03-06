package com.chenming.androiduidemo.Demo.ProgressBar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

public class SeekBarDemo extends DemoActivity {

    private ImageView image ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_demo);


        image = (ImageView) findViewById(R.id.image);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            // 当拖动条的滑块位置发生改变时触发该方法
            @Override
            public void onProgressChanged(SeekBar arg0, int progress,
                                          boolean fromUser)
            {
                // 动态改变图片的透明度
                image.setImageAlpha(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar)
            {
            }
            @Override
            public void onStopTrackingTouch(SeekBar bar)
            {
            }
        });

    }
}
