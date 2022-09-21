package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
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
        findViewById(R.id.button).setOnClickListener(onClickListener); //内部类写法

        findViewById(R.id.btn_to_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent threeIntent = new Intent("com.example.learn.ThirdActivity");
                startActivity(threeIntent);
//                Intent intent = new Intent(MainActivity.this,ExplodeActivity.class);
//                startActivity(intent, ActivityOptions.
//                        makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
        findViewById(R.id.btn_to_exp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent threeIntent = new Intent("com.example.learn.ThirdActivity");
//                startActivity(threeIntent);
                Intent intent = new Intent(MainActivity.this,ExplodeActivity.class);
                startActivity(intent, ActivityOptions.
                        makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });


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
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
            }
            else{
                Toast.makeText(MainActivity.this,"用户密码错误",
                        Toast.LENGTH_LONG).show();
            }

        }
    };
}