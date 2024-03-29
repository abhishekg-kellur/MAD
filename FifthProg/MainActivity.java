package com.example.fifthprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText uname, pwd;
    Button login, cancel;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        login = findViewById(R.id.button);
        cancel = findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = uname.getText().toString();
                String password = pwd.getText().toString();

                int id = checkUser(new User(name, password));

                if(id == -1) {
                    Snackbar.make(view, "User " + name + " does not exists", Snackbar.LENGTH_LONG).show();
                }
                else {
                    Snackbar.make(view, "User " + name + " exists", Snackbar.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            }
        });

        db = new DbHandler(MainActivity.this);
        db.addUser(new User("abc","1234"));
        db.addUser(new User("xyz","5678"));
    }

    private int checkUser(User user) {
        return db.checkUser(user);
    }

}