package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    private LinearLayout llRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_res_another).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eta = (EditText) findViewById(R.id.et_numa);
                double numa = Double.parseDouble(eta.getText().toString());
                EditText etb = (EditText) findViewById(R.id.et_numb);
                double numb = Double.parseDouble(etb.getText().toString());
                double res = numa * numb;

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("res", String.format("%.2f", res));
                startActivity(intent);
            }
        });

        findViewById(R.id.button_res_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eta = (EditText) findViewById(R.id.et_numa);
                double numa = Double.parseDouble(eta.getText().toString());
                EditText etb = (EditText) findViewById(R.id.et_numb);
                double numb = Double.parseDouble(etb.getText().toString());
                double res = numa * numb;
                String msg = String.format("%.2f", res);

                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("res", msg);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("MainActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        Log.i("MainActivity", "onDestroy");
        super.onDestroy();
    }
}