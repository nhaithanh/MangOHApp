package com.example.firstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    private ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Using setContentView if create splash screen by layout
        setContentView(R.layout.activity_splash_screen);
        imgView=(ImageView)findViewById(R.id.imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

        Animation animate = AnimationUtils.loadAnimation(this, R.anim.splash_screen);
        imgView.startAnimation(animate);
    }


}
