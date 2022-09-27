package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentContainer fragmentOne;
    private FragmentContainer fragmentTwo;
    private FragmentContainer fragmentThree;

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

        fragmentOne=new FragmentContainer(1);
        fragmentTwo=new FragmentContainer(2);
        fragmentThree=new FragmentContainer(3);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_remove).setOnClickListener(this);
        findViewById(R.id.btn_replace).setOnClickListener(this);
        findViewById(R.id.btn_hide).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        switch(v.getId()){
            case(R.id.btn_add):
                transaction.add(R.id.fl_container,fragmentOne);
                transaction.add(R.id.fl_container,fragmentTwo);
                transaction.addToBackStack(null);
                break;
            case(R.id.btn_remove):
                transaction.remove(fragmentTwo);
                break;
            case(R.id.btn_replace):
                transaction.replace(R.id.fl_container,fragmentThree);
                transaction.addToBackStack(null);
                break;
            case(R.id.btn_hide):
                transaction.hide(fragmentThree);
                break;
            case(R.id.btn_show):
                transaction.show(fragmentThree);
                break;
        }
        transaction.commit();
    }
}