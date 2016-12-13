package com.chenming.androiduidemo.BaseActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chenming.androiduidemo.Demo.AdapterView.AdapterViewDemoIndex;
import com.chenming.androiduidemo.Model.DemoInfo;
import com.chenming.androiduidemo.Model.DemoItemClickListener;
import com.chenming.androiduidemo.Model.DemoListAdapter;
import com.chenming.androiduidemo.R;

public class DemoIndexActivity extends AppCompatActivity {

    private ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }


    }

    public void SetData(Context context,DemoInfo[] demo){
        listView = (ListView)findViewById(R.id.listView) ;
        listView.setAdapter(new DemoListAdapter(context,demo));
        listView.setOnItemClickListener(new DemoItemClickListener(context,demo));
    }

}
