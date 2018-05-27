package com.example.alexl.lab2;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class fragment1 extends Fragment {
    private EditText from;
    private EditText to;
    private RadioButton mAM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment1_main, container, false);
        from = (EditText) rootView.findViewById(com.example.alexl.lab2.R.id.from);
        to = (EditText) rootView.findViewById(com.example.alexl.lab2.R.id.to);
        mAM = (RadioButton) rootView.findViewById(com.example.alexl.lab2.R.id.radioButton4);
        mAM.setChecked(true);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                String daypart = mAM.isChecked() ? "Вдень" : "Вночі";
                alert.setTitle("Вибрані дані:");
                alert.setMessage("Від: " + from.getText().toString() + " До: " + to.getText().toString() + " Коли: " + daypart);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                String str = "Від: " + from.getText().toString() + " До: " + to.getText().toString() + " Коли: " + daypart;
                alert.show();
                fragment2 fragment2 = (fragment2) (getActivity().getFragmentManager().findFragmentById(R.id.fragment2));
                fragment2.fill(str);
            }
        });
        return rootView;
    }

}
