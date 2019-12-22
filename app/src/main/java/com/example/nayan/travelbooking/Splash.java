package com.example.nayan.travelbooking;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    private static int SPLASH = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


            new Handler().postDelayed(new Runnable() {
                                          @Override
                                          public void run() {
                                              Intent homeintent = new Intent(Splash.this, selectionpage.class);
                                              startActivity(homeintent);
                                              finish();
                                          }
                                      }, SPLASH
            );
        }
    }



