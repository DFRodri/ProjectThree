package com.example.android.projectthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created with the help of
 * https://www.bignerdranch.com/blog/splash-screens-the-right-way/
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent splash = new Intent(this, MainActivity.class);
        startActivity(splash);
        finish();
    }
}
