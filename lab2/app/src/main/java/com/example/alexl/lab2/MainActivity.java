package com.example.alexl.lab2;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    private String chosenCategory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment2 = getFragmentManager().findFragmentById(R.layout.fragment2_main);
    }
}