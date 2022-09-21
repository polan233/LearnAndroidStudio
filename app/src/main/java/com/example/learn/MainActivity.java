package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_SECONDACTIVITY_CODE = 2;
    private LinearLayout llRootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.learn.SecondActivity");
                intent.putExtra("msg","Hello from MainActivity!");
                startActivityForResult(intent,REQUEST_SECONDACTIVITY_CODE);
            }
        });
        findViewById(R.id.btn_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("smsto:10086");
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("sms_body","Hello,I am learning Android Studio.");
                startActivity(intent);

            }
        });
        findViewById(R.id.btn_brow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.baidu.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(intent,"选择浏览器"));
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==REQUEST_SECONDACTIVITY_CODE&&RESULT_OK==resultCode){
            String resultStr =data.getStringExtra("result");
            Toast.makeText(MainActivity.this,resultStr,Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }



}