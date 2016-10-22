package com.miguelmjro.appstore.pearstroe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import 	android.os.Handler;
import android.text.Html;

import com.miguelmjro.appstore.pearstroe.tareas.LlamadoWS;

import java.net.URL;


public class Splash extends AppCompatActivity {


    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new LlamadoWS(Splash.this).execute("https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json");
    }
}
