package com.example.sassydesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginActivity LA = (LoginActivity) LoginActivity.activity;
        LA.finish();

        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");
        String PW = intent.getStringExtra("PW");

        Toast temp = Toast.makeText(this.getApplicationContext(), "ID =" + ID + "PW = " + PW, Toast.LENGTH_LONG);
        temp.show();

        MainTopBar mainTopBar = new MainTopBar();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, mainTopBar).commit();
    
    }
}