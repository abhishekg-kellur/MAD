package com.example.secondpractice;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    int progressStatus = 0;
    TextView tv;
    Button b;
    Handler hd = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressBar);
        tv = findViewById(R.id.progressView);
        b = findViewById(R.id.exitbutton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Want to exit?");
                builder.setTitle("Exit?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    finish();
                });
                builder.setNegativeButton("No", (dialog, which) -> {
                    dialog.cancel();
                });
                builder.setNeutralButton("Cancel", (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus < 100) {
                    progressStatus += 5;
                    hd.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(progressStatus);
                            tv.setText(progressStatus + "%");
                        }
                    });
                    try {
                        Thread.sleep(200);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}