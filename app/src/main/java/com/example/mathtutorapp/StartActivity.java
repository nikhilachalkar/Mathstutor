package com.example.mathtutorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;

import java.util.Locale;


public class StartActivity extends AppCompatActivity {

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        tts= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i!=TextToSpeech.ERROR)
                {
                    Locale language= new Locale ("en","IN");
                    tts.setLanguage(language);
                }
            }
        });



        Handler handler = new Handler();

        Runnable runnable = () -> {
            tts.speak("welcome to Maths-tutor",TextToSpeech.QUEUE_FLUSH,null,null);

            startActivity(new Intent(this,MainActivity.class));
        };

        // Post the Runnable with a delay
        handler.postDelayed(runnable, 3000);
    }
}