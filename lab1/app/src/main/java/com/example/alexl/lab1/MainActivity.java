package com.example.alexl.lab1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    private EditText from;
    private EditText to;
    private RadioButton mAM;
    private RadioGroup mRadioOsGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioOsGroup = (RadioGroup) findViewById(R.id.rdgrp);
        from =(EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        mAM = (RadioButton) findViewById(R.id.radioButton4);
        mAM.setChecked(true);


    }


    public void onClick1(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        String daypart = mAM.isChecked() ? "Вдень" : "Вночі";
        alert.setTitle("Вибрані дані:");
        alert.setMessage("Від: "+ from.getText().toString() +" До: "+ to.getText().toString()+ " Коли: "+ daypart);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });

        alert.show();
    }
}
