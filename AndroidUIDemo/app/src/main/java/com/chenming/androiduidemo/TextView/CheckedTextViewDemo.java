package com.chenming.androiduidemo.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Toast;

import com.chenming.androiduidemo.R;

public class CheckedTextViewDemo extends AppCompatActivity {
    private CheckedTextView checkedTextView;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_text_view_demo);
        addListenerOnButton();

        Intent intent = getIntent() ;
        if(intent.hasExtra("title")){
            setTitle( intent.getExtras().getString("title") );

        }
    }


    public void addListenerOnButton() {
        checkedTextView = (CheckedTextView) findViewById(R.id.my_checkedtextview);
        btnDisplay = (Button) findViewById(R.id.button1);

        checkedTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkedTextView.toggle();
                if (checkedTextView.isChecked()) {
                    checkedTextView.setText("Checked");

                } else {
                    checkedTextView.setText("Unchecked");
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                if(checkedTextView.isChecked())
                    result.append("Checked Text View : checked");
                else
                    result.append("Checked Text View : unchecked");

                Toast.makeText(CheckedTextViewDemo.this, result.toString(),
                        Toast.LENGTH_SHORT).show();

            }

        });

    }
}
