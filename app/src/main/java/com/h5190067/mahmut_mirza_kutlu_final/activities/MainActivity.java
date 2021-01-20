package com.h5190067.mahmut_mirza_kutlu_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190067.mahmut_mirza_kutlu_final.R;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.AlertUtil;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.ConnectionUtil;
import com.h5190067.mahmut_mirza_kutlu_final.utilities.Constant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashScreen();
    }

    public void splashScreen(){
        CountDownTimer splashTimer = new CountDownTimer(Constant.TIME_FOR_SPLASH_SCREEN, Constant.INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                changeActivity();
            }
        };
        splashTimer.start();
    }
    private void changeActivity(){
        if(ConnectionUtil.IsConnectionThere(getApplicationContext()))
        {
            Intent golfIntent = new Intent(getApplicationContext(), GolfsActivity.class);
            startActivity(golfIntent);
            finish();
        }
        else{
            AlertUtil.giveAlert(this, getString(R.string.AlertTitle), getString(R.string.AlertMessage), true);
        }
    }
}