package com.chenming.androiduidemo.AdapterView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chenming.androiduidemo.R;

public class ListViewDemo extends AppCompatActivity {

    private ListView listView1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }

        listView1 = (ListView)findViewById(R.id.listview1) ;
        //监听点击事件
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewDemo.this,
                        getResources().getStringArray(R.array.books)[position],Toast.LENGTH_SHORT).show();
            }
        });
        //监听滚动到底端的事件
        listView1.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                /**
                 * scrollState三种状态
                 * SCROLL_STATE_IDLE 不滚动
                 * SCROLL_STATE_FLING 正在滚动
                 * SCROLL_STATE_TOUCH_SCROLL 手还在listview上
                 */
                switch (scrollState){
                    case SCROLL_STATE_IDLE:
                        //判断滑动到最底端  方法：判断最下面的是不是最后一个
                        if(listView1.getLastVisiblePosition()==(listView1.getCount()-1)){
                            Toast.makeText(ListViewDemo.this,
                                    "已经滑动到最底端了。",Toast.LENGTH_SHORT).show();
                        }

                        else if(listView1.getFirstVisiblePosition()==0){
                            Toast.makeText(ListViewDemo.this,
                                    "已经滑动到最顶端了。",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }
}
