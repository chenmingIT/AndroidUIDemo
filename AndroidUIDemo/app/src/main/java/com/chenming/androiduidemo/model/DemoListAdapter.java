package com.chenming.androiduidemo.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.chenming.androiduidemo.R;

/**
 * Created by ChenMing on 2016/11/7.
 * Demo列表适配器
 * 初始化参数 1、上下文信息 2、DEMOS
 */

public class DemoListAdapter extends BaseAdapter {

    private Context context ;
    private DemoInfo[] DEMOS;

    public DemoListAdapter( Context context , DemoInfo[] DEMOS ) {
        this.DEMOS = DEMOS;
        this.context = context;
    }

    @Override
    public int getCount() {
        //在此适配器中所代表的数据集中的条目数
        return DEMOS.length;
    }

    @Override
    public Object getItem(int position) {
        //获取数据集中与指定索引对应的数据项
        return DEMOS[position] ;
    }

    @Override
    public long getItemId(int position) {
        //取在列表中与指定索引对应的行id
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //返回的view作为列表框每一条
        convertView = View.inflate(context, R.layout.demo_info_item, null);
        //convertView = View.inflate(MainActivity.this, R.layout.demo_info_item, null);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(DEMOS[position].getTitle());
        return convertView;
    }
}
