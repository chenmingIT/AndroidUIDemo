package com.chenming.androiduidemo.TextView;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.chenming.androiduidemo.R;

public class ChronometerDemo extends AppCompatActivity {
    Chronometer ch;
    Button start,stop,empty;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer_demo);
        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );
        }


        // 获取计时器组件
        ch = (Chronometer) findViewById(R.id.chronometer);
        // 获取按钮
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop) ;
        empty = (Button) findViewById(R.id.empty) ;

        //设置初始值
        //SystemClock.elapsedRealtime()表示计时器从启动到现在经过的时间
        ch.setBase(SystemClock.elapsedRealtime());
        start.setEnabled(true);
        stop.setEnabled(false);
        empty.setEnabled(false);

        /**
         * 启动按钮监听事件
         */
        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View source)
            {
                // 设置开始计时时间
                //ch.setBase(SystemClock.elapsedRealtime());
                // 启动计时器
                ch.start();
                start.setEnabled(false);
                empty.setEnabled(false);
                stop.setEnabled(true);
            }
        });
        /**
         * 暂停按钮监听事件
         */
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.stop();
                start.setEnabled(true);
                empty.setEnabled(true);
                stop.setEnabled(false);
            }
        });
        /**
         * 清空按钮监听事件
         */
        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SystemClock.elapsedRealtime()表示计时器从启动到现在经过的时间，由于暂停 所以0
                ch.setBase(SystemClock.elapsedRealtime()); //计时器归0
                start.setEnabled(true);
                empty.setEnabled(false);
                stop.setEnabled(false);
            }
        });
        // 为Chronometer绑定事件监听器
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()
        {
            @Override
            public void onChronometerTick(Chronometer ch)
            {

            }
        });
    }
}
