package com.example.madlab05;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txtTime;
    CountDownTimer countDownTimer;


    public void start(View view) {

        countDownTimer.start();

    }

    public void stop(View view) {
        countDownTimer.cancel();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = findViewById(R.id.txtTime);


        countDownTimer = new CountDownTimer(86400000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long hour = ((86400000 - millisUntilFinished) / 3600000) % 24;
                long min = ((86400000 - millisUntilFinished) / 60000) % 60;
                long sec = ((86400000 - millisUntilFinished) / 1000) % 60;

                String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, min, sec);
                txtTime.setText(time);


            }

            @Override
            public void onFinish() {

                txtTime.setText("00:00:00");
            }
        };


    }
}