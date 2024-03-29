package com.example.firstpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ImageButton b1;
    Switch s;
    ConstraintLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.imageButton);
        s = findViewById(R.id.switch1);
        l1 = findViewById(R.id.constraintLayout);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    b1.setEnabled(true);
                    s.setText("Enabled");
                }
                else {
                    b1.setEnabled(false);
                    s.setText("Disabled");
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Button clicked", Snackbar.LENGTH_LONG).show();
            }
        });

        CalendarView cv = new CalendarView(getApplicationContext());
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        l1.addView(cv, params);
    }
}