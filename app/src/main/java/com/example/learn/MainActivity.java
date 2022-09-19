package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llRootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llRootView=(LinearLayout) findViewById(R.id.ll_root_view);
        findViewById(R.id.button).setOnClickListener(onClickListener);


    }


    private View.OnClickListener onClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            EditText eNick =(EditText) findViewById(R.id.et_nickname);
            EditText ePass =(EditText) findViewById(R.id.et_password);
            String user = eNick.getText().toString();
            String pass = ePass.getText().toString();
            if(user.equals("lth")&&pass.equals("123")){
                Toast.makeText(MainActivity.this,"用户密码正确",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SecondActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this,"用户密码错误",
                        Toast.LENGTH_LONG).show();
            }

        }
    };
}