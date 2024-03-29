package com.example.fifthpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login, register;
    DbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                //handle addUser to DB
                db = new DbHandler(getApplicationContext());
                db.addUser(new User(name, pass));

                username.setText("");
                password.setText("");
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                //check user existence in DB
                int id = userExists(new User(name, pass));

                if (id == -1) {
                    Snackbar.make(view, "User " + name + " does not exist or password incorrect", Snackbar.LENGTH_SHORT).show();
                }
                else {
                    Snackbar.make(view, "User " + name + " exists", Snackbar.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("Username", name);
                    startActivity(i);
                }
            }
        });
    }

    public int userExists(User user) {
        return db.checkUser(user);
    }
}