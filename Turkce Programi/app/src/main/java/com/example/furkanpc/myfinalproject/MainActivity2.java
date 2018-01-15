package com.example.furkanpc.myfinalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by FurkanPC on 12.01.2017.
 */

public class MainActivity2 extends Activity {

    ImageButton btnSearch;
    EditText et;
    AlertDialog alertDialog;
    String kelime ;
    Button otherActivity;
    String [] sonuc;
    Bundle bund;
    Fragment fragobj;
    FragmentTransaction transaction;
    LinearLayout l1,l2;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main2);

        et = (EditText) findViewById(R.id.et2);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch2);
        l1 = (LinearLayout) findViewById(R.id.innerLayout2);
        otherActivity = (Button) findViewById(R.id.btnGoOtherActivity2);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kelime = et.getText().toString().toLowerCase();
                sonuc = resultOfWord(kelime);
                bund = new Bundle();
                bund.putStringArray("sonuc",sonuc);
                bund.putString("kelime",kelime);
                fragobj = new MainFragment2();
                fragobj.setArguments(bund);
                transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.myFrameLayout2 , fragobj);
                transaction.commit();
                l1.setVisibility(View.GONE);



            }
        });

    }

    @Override
    public void onBackPressed() {

        Fragment remove = getFragmentManager().findFragmentById(R.id.myFrameLayout2);

        if(remove != null) {

            l1.setVisibility(View.VISIBLE);
            transaction = getFragmentManager().beginTransaction();
            transaction.remove(remove);
            transaction.commit();
        }
        else super.onBackPressed();
    }

    public String[] resultOfWord(String s){
        String result;
        TurkceImla im = new TurkceImla(s);

        return im.getResult();
    }

}
