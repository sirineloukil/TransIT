package com.example.transit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signup extends AppCompatActivity {

    private Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        button=(Button)  findViewById(R.id.log_in);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDashboard();
            }
        });
    }
    public void openActivityDashboard(){
        Intent intent = new Intent(this,Dashboard.class);
        startActivity(intent);
    }
}