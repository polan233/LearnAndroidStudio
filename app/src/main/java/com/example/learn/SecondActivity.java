package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn=(Button) findViewById(R.id.button2);
        btn.setOnClickListener(OnclickListener);


        Intent intent=getIntent();
        String msg=intent.getExtras().getString("msg");
        if (msg!=null){
            TextView tv=findViewById(R.id.textView);
            tv.setText(msg);
        }


    }
    private View.OnClickListener OnclickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.putExtra("result","SecondActivity is fine and you?");
            setResult(RESULT_OK,intent);
            finish();

        }
    };
}