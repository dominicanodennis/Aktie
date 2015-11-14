package com.example.dennis.aktie;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dennis on 06.11.15.
 */
public class AktiendetailFragment extends Fragment {

    TextView textView;
    double num = 10;
    int num2 = 2;


    public AktiendetailFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_aktiendetail,container,false);

        Intent empfangenerIntent = getActivity().getIntent();

       if (empfangenerIntent != null && empfangenerIntent.hasExtra(Intent.EXTRA_TEXT)){

           String aktienInfo = empfangenerIntent.getStringExtra(Intent.EXTRA_TEXT);

       //   ((TextView) rootView.findViewById(R.id.aktiendetail_text)).setText(aktienInfo);
          textView = (TextView) rootView.findViewById(R.id.aktiendetail_text);
           textView.setText(aktienInfo);

       }

        return rootView;
    }
}
