package com.example.furkanpc.myfinalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainActivity extends Activity {

    TextView t;
    EditText et;
    ImageButton btnSearch;
    PageParse p;
    Bundle bund;
    MainFragment1 fragobj;
    FragmentTransaction transaction;
    String kelime;
    AlertDialog alertDialog;
    Button kendiSozlugum;
    LinearLayout l ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        t = (TextView) findViewById(R.id.myTxt);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);
        kendiSozlugum = (Button) findViewById(R.id.kendiSozlugum);
        l = (LinearLayout) findViewById(R.id.lay1) ;

        kendiSozlugum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kelime = et.getText().toString().toLowerCase();
                p = new PageParse(kelime);
                p.execute();
                et.setVisibility(View.GONE);
                kendiSozlugum.setVisibility(View.GONE);
                btnSearch.setVisibility(View.GONE);
                l.setVisibility(View.GONE);
                InputMethodManager imm = (InputMethodManager)getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
            }
        });

    }

    @Override
    public void onBackPressed() {

        Fragment remove = getFragmentManager().findFragmentById(R.id.myFrame);

        if(remove != null) {

            et.setVisibility(View.VISIBLE);
            kendiSozlugum.setVisibility(View.VISIBLE);
            btnSearch.setVisibility(View.VISIBLE);
            l.setVisibility(View.VISIBLE);

            transaction = getFragmentManager().beginTransaction();
            transaction.remove(remove);
            transaction.commit();

        }
        else super.onBackPressed();
    }

    class PageParse extends AsyncTask<String ,Void ,String>{

        private String s;
        String enEskiKaynak ,anlam,koken,ekAciklama ;
        public PageParse(String str){
            this.s = str ;
        }
        @Override
        protected String doInBackground(String... strings) {
            Document doc = null;
            try {
                doc = Jsoup.connect("http://www.etimolojiturkce.com/kelime/"+s).get();
                enEskiKaynak = doc.select("#spanScrap2").text();
                anlam = doc.select(".ety3").text();
                koken = doc.select("#spanScrap3").text();
                ekAciklama = doc.select("#spanScrap4").text();


            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Executed...";
        }
        @Override
        protected void onPostExecute(String result) {
            bund = new Bundle();
            bund.putString("kelime", s);
            bund.putString("enEskiKaynak",getEnEskiKaynak());
            bund.putString("anlam",getAnlam());
            bund.putString("koken",getKoken());
            bund.putString("ekAciklama",getEkAciklama());
            fragobj = new MainFragment1();
            fragobj.setArguments(bund);
            transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.myFrame , fragobj);
            transaction.commit();

        }

        public String getEnEskiKaynak(){
            return enEskiKaynak;
        }
        public String getAnlam(){
            return anlam;
        }
        public String getKoken(){
            return koken;
        }
        public String getEkAciklama(){
            return ekAciklama;
        }
    }
}
