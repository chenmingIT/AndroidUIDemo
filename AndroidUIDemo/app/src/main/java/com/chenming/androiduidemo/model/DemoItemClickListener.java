package com.chenming.androiduidemo.Model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;


/**
 * Created by ChenMing on 2016/11/7.
 * Demo列表项点击事件
 */

public class DemoItemClickListener implements AdapterView.OnItemClickListener{

    private Context context ;
    private DemoInfo[] DEMOS;

    public DemoItemClickListener(Context context, DemoInfo[] DEMOS) {
        this.context = context;
        this.DEMOS = DEMOS;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onListItemClick(position);
    }

    /**
     * @param index
     * 点击ListView的一条记录时候调用
     */
    void onListItemClick(int index) {
        Intent intent;
        intent = new Intent(context, DEMOS[index].getDemoClass());
        //传入标题
        intent.putExtra("title",DEMOS[index].getTitle()) ;
        context.startActivity(intent);
    }
}
