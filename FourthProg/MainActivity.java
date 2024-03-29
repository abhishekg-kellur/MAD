package com.example.fourthpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FragmentOne f1 = new FragmentOne();
    FragmentTwo f2 = new FragmentTwo();
    int showing = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameLayout, f1);
        ft.commit();
        showing = 1;
    }

    public void switchFragment(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (showing == 1) {
            ft.replace(R.id.frameLayout, f2);
            showing = 2;
        } else {
            ft.replace(R.id.frameLayout, f1);
            showing = 1;
        }
        ft.commit();
    }
}