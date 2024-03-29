package com.example.thirdpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name, sap;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        sap = findViewById(R.id.sap);
        b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname = name.getText().toString();
                String ssap = sap.getText().toString();

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("name", sname);
                i.putExtra("sap", ssap);
                startActivity(i);
            }
        });
    }
}