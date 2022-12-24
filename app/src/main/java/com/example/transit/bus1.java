package com.example.transit;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import nl.joery.animatedbottombar.AnimatedBottomBar;
import timber.log.Timber;

public class bus1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = bus1.class.getSimpleName();
    private DrawerLayout drawer;
    /////

    AnimatedBottomBar animatedBottomBar;
    Fragment fragment;
    FragmentManager fragmentManager;
    ///open new activity from scroll view
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    //// DATABASE HELPER
    DataHelper myDb;
    ///MapView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bOttom Navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment1,
                    new HomeFragment()).commit();

        }
        ////ANIMATED BOTTOM NAVIGATION//**
        animatedBottomBar=findViewById(R.id.animatedBottomBar);
        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @org.jetbrains.annotations.Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NonNull AnimatedBottomBar.Tab newTab) {
                HomeFragment fragment=null;
                switch (newTab.getId()){

                }
                if(fragment!=null){
                    fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container_view_tag,fragment).commit();
                }else{
                    Timber.e("error in creating Fragment");
                }
            }
        });

//open new activity from scroll view
        button1=(Button) findViewById(R.id.ligne1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        button2=(Button) findViewById(R.id.ligne2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button3=(Button) findViewById(R.id.ligne3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button4=(Button) findViewById(R.id.ligne4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button5=(Button) findViewById(R.id.ligne5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        button6=(Button) findViewById(R.id.ligne6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
        button7=(Button) findViewById(R.id.ligne7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
        button8=(Button) findViewById(R.id.ligne8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });
        button9=(Button) findViewById(R.id.ligne9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity9();
            }
        });
        button10=(Button) findViewById(R.id.ligne10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity10();
            }
        });
        ///DATABASE HELPER
        myDb= new DataHelper(this);

    }
    //////BOTTOM NAVIGATION////***
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_param:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment1,
                        new ParamétreFragment()).commit();
                break;
            case R.id.nav_Rate:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment1,
                        new RateFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Partage", Toast.LENGTH_SHORT).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /////open new acivity from scroll view
    public void openActivity1(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent=new Intent(this, MapView.class);
        startActivity(intent);
    }
    public void openActivity7(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity8(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity9(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }
    public void openActivity10(){
        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);
    }


}




