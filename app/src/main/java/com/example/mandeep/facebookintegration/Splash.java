package com.example.mandeep.facebookintegration;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.FacebookSdk;

/**
 * Created by Mandeep on 14-06-2016.
 */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                String profile = getSharedPreferences("fbPrefs", MODE_PRIVATE).getString("profile", "NA");
                Intent intent;
                if (profile.equalsIgnoreCase("NA")) {
                    //not logged in
                    intent = new Intent(Splash.this, MainActivity.class);
                } else {
                    //already logged in
                    //initialize the facebook sdk
                    FacebookSdk.sdkInitialize(getApplicationContext());

                    intent = new Intent(Splash.this, HomeActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
