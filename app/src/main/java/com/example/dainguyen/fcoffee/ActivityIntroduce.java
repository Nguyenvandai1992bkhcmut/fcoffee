package com.example.dainguyen.fcoffee;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * Created by dainguyen on 4/4/17.
 */

public class ActivityIntroduce extends AppCompatActivity {
    private FrameLayout frameLayout ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direc);

        setupLayout();
    }

    public void setupLayout(){
        frameLayout = (FrameLayout)findViewById(R.id.frame);
        fragment_direct fragment_direct = new fragment_direct();
        getSupportFragmentManager().beginTransaction().add(R.id.frame,fragment_direct).commit();
    }
}
