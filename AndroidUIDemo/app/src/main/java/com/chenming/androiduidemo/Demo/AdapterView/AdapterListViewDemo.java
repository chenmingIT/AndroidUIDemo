package com.chenming.androiduidemo.Demo.AdapterView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterListViewDemo extends DemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_list_view_demo);

        initListViewByArrayAdapter();
        initListViewBySimpleAdapter();
        initListViewByBaseAdapter();
    }

    /**
     * 使用ArrayAdapter创建ListView
     */
    private void initListViewByArrayAdapter(){
        ListView listView1 = (ListView)findViewById(R.id.list1) ;
        String []str1 = {"item1","item2","item3"} ;
        //包装ArrayAdapter
        //参数1、上下文 2、单个行的布局 数组
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.array_item,str1
        ) ;
        listView1.setAdapter(adapter);
    }
    /**
     * 使用ArrayAdapter创建ListView
     */
    private void initListViewBySimpleAdapter(){
        String []names = new String[]{"name1","name2","name3","name4"} ;
        String []intros = new String[]{"intro1..","intro2...","intro3...","intro4..."} ;
        int []images = new int[]{R.drawable.qiao,R.drawable.qiao,R.drawable.shui,R.drawable.shui} ;
        // 创建一个List集合，List集合的元素是Map
        List< Map<String,Object> > listItems = new ArrayList< Map<String,Object> >() ;
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header",images[i]) ;
            listItem.put("personName", names[i]);
            listItem.put("intro", intros[i]);
            listItems.add(listItem) ;
        }
        //包装SimpleAdapter
        //参数1、上下文 2、list< map<key,object> >
        //3、key组 4、key对应的布局文件里的id
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,listItems,R.layout.simple_item,
                new String[]{"personName","header","intro"},
                new int[]{R.id.name,R.id.header,R.id.intro}
        );

        ListView listView2 = (ListView)findViewById(R.id.list2) ;
        listView2.setAdapter(simpleAdapter);
    }
    /**
     * 使用BaseAdapter创建ListView
     */
    //包装BaseAdapter
    //主要实现里面的方法
    private void initListViewByBaseAdapter(){
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            //数量
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            //获取position位置的View
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(AdapterListViewDemo.this) ;
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(AdapterListViewDemo.this) ;
                imageView.setImageResource(R.drawable.shui);
                //动态设置大小
                imageView.setLayoutParams(new ViewGroup.LayoutParams(50,50));

                TextView textView = new TextView(AdapterListViewDemo.this) ;
                textView.setText("第"+(position+1)+"个列表项");
                textView.setTextSize(20);
                textView.setTextColor(Color.RED);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout ;
            }
        };
        ListView listView = (ListView)findViewById(R.id.list3) ;
        listView.setAdapter(baseAdapter);
    }
}
