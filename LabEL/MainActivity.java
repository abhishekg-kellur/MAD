package com.example.maimactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvClockText;

    Button startPauseButton;

    Button resetBtn;

    CountDownTimer timer;

    int seconds = 0;

    int minutes = 0;

    int hours = 0;

    boolean is_timer_running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClockText = findViewById(R.id.tvClockText);
        startPauseButton = findViewById(R.id.btnStartPause);
        resetBtn = findViewById(R.id.btnReset);

        UpdateTimerText();

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                seconds++;

                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }

                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }

                UpdateTimerText();
            }

            @Override
            public void onFinish() {
                // This method is called when the timer finishes but since you're using it as a continuous timer, you don't need to start it again.
            }
        };

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_timer_running = !is_timer_running;

                if (is_timer_running) {
                    startPauseButton.setText("Pause");
                    timer.start();
                } else {
                    startPauseButton.setText("Start");
                    timer.cancel();
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                is_timer_running = false;
                startPauseButton.setText("Start");
                seconds = minutes = hours = 0;
                UpdateTimerText();
            }
        });
    }

    private void UpdateTimerText() {
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        tvClockText.setText(time);
    }
}
