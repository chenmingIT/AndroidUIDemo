package com.chenming.androiduidemo.ViewAnimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;
import com.chenming.androiduidemo.R;

public class ViewFlipperDemo extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper_demo);

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );
        }


        viewFlipper = (ViewFlipper) findViewById(R.id.details);
    }
    public void prev(View source)
    {
        viewFlipper.setInAnimation(this , R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this , R.anim.slide_out_left);
        // 显示上一个组件
        viewFlipper.showPrevious();
        // 停止自动播放
        viewFlipper.stopFlipping();
    }
    public void next(View source)
    {
        viewFlipper.setInAnimation(this , android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this , android.R.anim.slide_out_right);
        // 显示下一个组件
        viewFlipper.showNext();
        // 停止自动播放
        viewFlipper.stopFlipping();
    }
    public void auto(View source)
    {
        viewFlipper.setInAnimation(this , android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this , android.R.anim.slide_out_right);
        // 开始自动播放
        viewFlipper.startFlipping();
    }
}

