package com.chenming.androiduidemo.Demo.ViewAnimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageSwitcherDemo extends DemoActivity {

    private int[] imageIds = new int[]{
            R.drawable.bomb5 , R.drawable.bomb6 , R.drawable.bomb7
            , R.drawable.bomb8 , R.drawable.bomb9 , R.drawable.bomb10
            , R.drawable.bomb11 , R.drawable.bomb12 , R.drawable.bomb13
            , R.drawable.bomb14 , R.drawable.bomb15 , R.drawable.bomb16
    };
    private ImageSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher_demo);

        // 创建一个List对象，List对象的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 获取显示图片的ImageSwitcher
        switcher = (ImageSwitcher)
                findViewById(R.id.switcher);
        // 为ImageSwitcher设置图片切换的动画效果
        switcher.setFactory(new ViewSwitcher.ViewFactory()
        {
            @Override
            public View makeView()
            {
                // 创建ImageView对象
                ImageView imageView = new ImageView(ImageSwitcherDemo.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                // 返回ImageView对象
                return imageView;
            }
        });
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems
                // 使用/layout/cell.xml文件作为界面布局
                , R.layout.cell, new String[]{"image"},
                new int[] { R.id.image1 });
        GridView grid = (GridView) findViewById(R.id.grid01);
        // 为GridView设置Adapter
        grid.setAdapter(simpleAdapter);
        // 添加列表项被选中的监听器
        /*grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id)
            {
                // 显示当前被选中的图片
                switcher.setImageResource(imageIds[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });*/
        // 添加列表项被单击的监听器
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                // 显示被单击的图片
                switcher.setImageResource(imageIds[position]);
            }
        });
    }
}

