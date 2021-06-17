package com.alibi.triviaapp.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;

import com.alibi.triviaapp.MainActivity;
import com.alibi.triviaapp.R;

/**
 * This is Splash which is animating Trivia app name
 */
public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.alibi.triviaapp.databinding.ActivitySplashScreenBinding splashScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);


        // These lines of code describes setting of font to text
        Typeface typeface = ResourcesCompat.getFont(this, R.font.text_font);
        splashScreenBinding.textView.setTypeface(typeface);

        // These lines of code describes setting of animation Over text
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.text_anim);
        splashScreenBinding.textView.setAnimation(animation);

        /*
         * these lines of code describing how to screen for given seconds
         * (here we have given 3 sec and after that
         * it will hit given implicit intent
         */
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}