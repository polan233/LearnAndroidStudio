package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdActivity.this,"这是一个Toast",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_custom_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                CustomToast.getInstance().showToastCustom(ThirdActivity.this,"自定义Toast在顶部", Gravity.TOP);
            }
        });
        findViewById(R.id.button_custom_mid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                CustomToast.getInstance().showToastCustom(ThirdActivity.this,"自定义Toast在中间", Gravity.CENTER);
            }
        });
        findViewById(R.id.button_custom_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                CustomToast.getInstance().showToastCustom(ThirdActivity.this,"自定义Toast在底部", Gravity.BOTTOM);
            }
        });
    }
}