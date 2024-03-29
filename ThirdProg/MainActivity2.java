package com.example.thirdpractice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView name, sap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.textname);
        sap = findViewById(R.id.textsap);

        Intent i = getIntent();
        String sname = i.getStringExtra("name");
        String ssap = i.getStringExtra("sap");
        name.setText(sname);
        sap.setText(ssap);
    }
}