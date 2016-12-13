package com.chenming.androiduidemo.Demo.ImageView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ZoomButton;
import android.widget.ZoomControls;


import com.chenming.androiduidemo.BaseActivity.DemoActivity;
import com.chenming.androiduidemo.R;

public class ImageButtonDemo  extends DemoActivity {

    private ZoomButton btn_zoom_down,btn_zoom_up  ;
    private TextView zoomButtonText ;
    float size1 ,size2 ;
    private ZoomControls zoomControls ;
    private TextView zoomControlsText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebutton_demo);


        btn_zoom_down = (ZoomButton)findViewById(R.id.btn_zoom_down) ;
        btn_zoom_up = (ZoomButton)findViewById(R.id.btn_zoom_up) ;
        zoomButtonText = (TextView)findViewById(R.id.zoomButtonText) ;

        size1 = zoomButtonText.getTextSize() ;//px单位
        size1 = px2dip(ImageButtonDemo.this,size1) ;  //转dp

        zoomControls = (ZoomControls)findViewById(R.id.zoomControls1) ;
        zoomControlsText = (TextView)findViewById(R.id.zoomControlsText) ;
        size2 = zoomControlsText.getTextSize() ;//px单位
        size2 = px2dip(ImageButtonDemo.this,size2) ;  //转dp

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btn_zoom_down)
                    size1 = size1 - 5 ;
                else if (v.getId() ==  R.id.btn_zoom_up)
                    size1 = size1 + 5 ;
                zoomButtonText.setTextSize(size1);

            }
        };
        btn_zoom_down.setOnClickListener(onClickListener) ;
        btn_zoom_up.setOnClickListener(onClickListener) ;

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size2 = size2 + 5 ;
                zoomControlsText.setTextSize(size2);
            }
        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size2 = size2 - 5 ;
                zoomControlsText.setTextSize(size2);
            }
        });
    }

    //px单位转dp
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
