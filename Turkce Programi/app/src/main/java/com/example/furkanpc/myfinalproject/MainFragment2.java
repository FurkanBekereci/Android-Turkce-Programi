package com.example.furkanpc.myfinalproject;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by FurkanPC on 12.01.2017.
 */

public class MainFragment2 extends Fragment {
    TextView sonucGoster ;
    String [] sonuc;
    String kelime;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v =  inflater.inflate(R.layout.main_fragment2,container,false);
        Drawable myImg = ResourcesCompat.getDrawable(getResources(), R.drawable.harfler5, null);
        myImg.setAlpha(20);
        v.setBackground(myImg);
        sonucGoster = (TextView) v.findViewById(R.id.txtSonucGoster);
        sonuc = getArguments().getStringArray("sonuc");
        kelime = getArguments().getString("kelime");
        String temp ="";
        for (String s : sonuc) {
            temp += s ;
        }

        sonucGoster.setText(temp);

        return v;
    }
}
