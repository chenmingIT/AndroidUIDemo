package com.chenming.androiduidemo.Demo.AdapterView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

public class AdapterViewFlipperDemo  extends DemoActivity {

    private int[] imageIds = new int[]{
            R.drawable.shuangzi, R.drawable.shuangyu,
            R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
            R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
            R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
            R.drawable.mojie
    };
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper_demo);

        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        // 创建一个BaseAdapter对象，该对象负责提供Gallery所显示的列表项
        BaseAdapter adapter = new BaseAdapter()
        {
            @Override
            public int getCount()
            {
                return imageIds.length;
            }
            @Override
            public Object getItem(int position)
            {
                return position;
            }
            @Override
            public long getItemId(int position)
            {
                return position;
            }
            // 该方法返回的View代表了每个列表项
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                // 创建一个ImageView
                ImageView imageView = new ImageView(AdapterViewFlipperDemo.this);
                imageView.setImageResource(imageIds[position]);
                // 设置ImageView的缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                // 为imageView设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }
    public void prev(View source)
    {
        // 显示上一个组件
        flipper.showPrevious();
        // 停止自动播放
        flipper.stopFlipping();
    }
    public void next(View source)
    {
        // 显示下一个组件。
        flipper.showNext();
        // 停止自动播放
        flipper.stopFlipping();
    }
    public void auto(View source)
    {
        // 开始自动播放
        flipper.startFlipping();
    }
}
