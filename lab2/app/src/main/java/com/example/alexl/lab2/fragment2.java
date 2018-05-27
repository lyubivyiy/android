package com.example.alexl.lab2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment2 extends Fragment {
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment2_main, container, false);
        textView = rootView.findViewById(R.id.textView);
        return rootView;
    }

    public void fill(String text){
        textView.setText(text);
    }
}
