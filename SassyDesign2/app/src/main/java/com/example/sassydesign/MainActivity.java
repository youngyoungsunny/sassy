package com.example.sassydesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        DailyScreen dailyScreen = new DailyScreen();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, dailyScreen).commit();
    
    }
}