package com.example.medphox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow ().setFlags (
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );getSupportActionBar ().hide ();
        //this is for splash time out
        new Handler().postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                Intent Homeintent=new Intent ( SplashActivity.this,ModalActivity.class );
                startActivity ( Homeintent );
                finish ();
            }
        } ,SPLASH_TIME_OUT);



    }
}