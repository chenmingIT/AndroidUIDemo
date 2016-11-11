package com.chenming.androiduidemo.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.chenming.androiduidemo.R;

public class ButtonDemo extends AppCompatActivity {

    //RadioGroup监听事件
    RadioGroup rg ;
    //CheckBox监听事件
    CheckBox checkBox1,checkBox2,checkBox3 ;
    //开关
    ToggleButton toggleButton ;
    Switch aSwitch1,aSwitch2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_demo);
        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );
        }

        //Radio时间监听
        rg = (RadioGroup)findViewById(R.id.rg) ;
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton1)
                    Toast.makeText(getApplicationContext(),"勾选了RadioGroup的选项一",Toast.LENGTH_SHORT).show();
                else if(checkedId == R.id.radioButton2)
                    Toast.makeText(getApplicationContext(),"勾选了RadioGroup的选项二",Toast.LENGTH_SHORT).show();
            }
        });

        //CheckBox事件监听
        checkBox1 = (CheckBox)findViewById(R.id.checkbox1) ;
        checkBox2 = (CheckBox)findViewById(R.id.checkbox2) ;
        checkBox3 = (CheckBox)findViewById(R.id.checkbox3) ;
        checkBox1.setOnCheckedChangeListener(new checkBoxOnChangedListener());
        checkBox2.setOnCheckedChangeListener(new checkBoxOnChangedListener());
        checkBox3.setOnCheckedChangeListener(new checkBoxOnChangedListener());

        //开关的监听
        toggleButton = (ToggleButton)findViewById(R.id.toggle) ;
        aSwitch1 = (Switch)findViewById(R.id.switcher1) ;
        aSwitch2 = (Switch)findViewById(R.id.switcher2) ;
        toggleButton.setOnCheckedChangeListener(new checkBoxOnChangedListener());
        aSwitch1.setOnCheckedChangeListener(new checkBoxOnChangedListener());
        aSwitch2.setOnCheckedChangeListener(new checkBoxOnChangedListener());

    }

    class checkBoxOnChangedListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.switcher1:
                case R.id.switcher2:
                case R.id.toggle:
                    if(isChecked==true) {
                        toggleButton.setChecked(true);
                        aSwitch1.setChecked(true);
                        aSwitch2.setChecked(true);
                    }
                    else{
                        toggleButton.setChecked(false);
                        aSwitch1.setChecked(false);
                        aSwitch2.setChecked(false);
                    }
                    break;
                default:
                    if(isChecked==true)
                        Toast.makeText(getApplicationContext(),
                                "勾选了CheckBox的"+buttonView.getText().toString(),Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(),
                                "取消了CheckBox的"+buttonView.getText().toString(),Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
