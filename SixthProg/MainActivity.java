package com.example.sixthpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText phNumber = findViewById(R.id.phno);
        EditText message = findViewById(R.id.msg);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager sm = SmsManager.getDefault();
                try {
                    sm.sendTextMessage(phNumber.getText().toString(), null, message.getText().toString(),null, null);
                    Snackbar.make(view, "SMS sent successfully", Snackbar.LENGTH_LONG).show();
                }
                catch(Exception e) {
                    Snackbar.make(view, "SMS failed", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }
}