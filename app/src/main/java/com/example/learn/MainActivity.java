package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout llRootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llRootView=(LinearLayout) findViewById(R.id.ll_root_view);
        findViewById(R.id.btn_add_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        TextView textView=new TextView(this);
        textView.setText("hello");
        llRootView.addView(textView);
    }
}