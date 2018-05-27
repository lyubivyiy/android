package com.example.alexl.lab3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private EditText from;
    private EditText to;
    private RadioButton mAM;
    private RadioGroup mRadioOsGroup;
    private final static String FILE_NAME = "content1.txt";


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
        alert.setTitle("Вибрані дані:");
        String daypart = mAM.isChecked() ? "Вдень" : "Вночі";
        alert.setMessage("Від: "+ from.getText().toString() +" До: "+ to.getText().toString()+ " Коли: "+ daypart);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });

        alert.show();
    }
    public void saveText(View view){

        FileOutputStream fos = null;
        try {
            String daypart = mAM.isChecked() ? "Вдень" : "Вночі";
            String str = "Від: " + from.getText().toString() + " До: " + to.getText().toString() + " Коли: " + daypart;

            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(str.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void openText(View view){

        FileInputStream fin = null;
        TextView textView = (TextView) findViewById(R.id.textView);
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            textView.setText(text);
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
