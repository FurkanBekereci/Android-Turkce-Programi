package com.example.furkanpc.myfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import org.jsoup.*;



public class MySplashScreen extends Activity {

    ImageView myImg;
    Animation myAnim;
    Animation myAnim2;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_splash_screen);
        myAnim = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        myAnim2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fade_out);
        myImg = (ImageView) findViewById(R.id.myImg);
        myImg.startAnimation(myAnim);


        myAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                myImg.startAnimation(myAnim2);
                finish();;
                Intent i = new Intent(MySplashScreen.this,MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
