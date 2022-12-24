package com.example.transit;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ChoixLangue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_langue);
        findViewById(R.id.btn_ar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("ar");
            }
        });
        findViewById(R.id.btn_en).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("en");
            }
        });
        findViewById(R.id.btn_fr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("fr");
            }
        });

    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        Configuration conf = getResources().getConfiguration();
        conf.locale = myLocale;
        getResources().updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
    }
}