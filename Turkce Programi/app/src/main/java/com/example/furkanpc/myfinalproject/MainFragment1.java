package com.example.furkanpc.myfinalproject;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by FurkanPC on 12.01.2017.
 */

public class MainFragment1 extends Fragment {

    TextView txtKelime,txtKoken,txtEnEskiKaynak,txtEkAciklama,txtAnlam;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String kelime = getArguments().getString("kelime");
        String koken = getArguments().getString("koken");
        String enEskiKaynak = getArguments().getString("enEskiKaynak");
        String ekAciklama = getArguments().getString("ekAciklama");
        String anlam = getArguments().getString("anlam");



        View v =  inflater.inflate(R.layout.main_fragment1,container,false);

        Drawable myImg = ResourcesCompat.getDrawable(getResources(), R.drawable.harfler5, null);
        myImg.setAlpha(20);
        v.setBackground(myImg);

        txtAnlam = (TextView) v.findViewById(R.id.txtAnlam);
        txtAnlam.setText(anlam);
        txtKoken = (TextView) v.findViewById(R.id.txtKoken);
        txtKoken.setText(koken);
        txtEnEskiKaynak = (TextView) v.findViewById(R.id.txtEnEskiKaynak);
        txtEnEskiKaynak.setText(enEskiKaynak);
        txtEkAciklama = (TextView) v.findViewById(R.id.txtEkAciklama);
        txtEkAciklama.setText(ekAciklama);
        txtKelime = (TextView) v.findViewById(R.id.txtKelime);
        txtKelime.setText(koken);
        return v;
    }
}
