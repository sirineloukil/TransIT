package com.example.transit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class Dashboard extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        button1 = (Button) findViewById(R.id.bus);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitybus1();
            }
        });
        button2 = (Button) findViewById(R.id.train);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitytrain1();
            }
        });
        button3 = (Button) findViewById(R.id.metro);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitymetro();
            }
        });
    }

    public void openActivitybus1() {
        Intent intent = new Intent(this, bus1.class);
        startActivity(intent);
    }

    public void openActivitytrain1() {
        Intent intent = new Intent(this, train1.class);
        startActivity(intent);
    }

    public void openActivitymetro() {
        Intent intent = new Intent(this, metro.class);
        startActivity(intent);
    }
}