package com.example.learn;

import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ExplodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT_WATCH){
            Transition explode = TransitionInflater.from(this).
                    inflateTransition(R.transition.explode);
            getWindow().setEnterTransition(explode);
        }

        setContentView(R.layout.activity_explode);


    }
}
