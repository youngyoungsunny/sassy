package com.example.sassydesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//메인 액티비티
//activity_main.xml
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //로그인 화면 종료
        LoginActivity LA = (LoginActivity) LoginActivity.activity;
//        LA.finish();

        //ID, PW 잘 넘어가는지 토스트 메시지로 확인
        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");
        String PW = intent.getStringExtra("PW");

        Toast temp = Toast.makeText(this.getApplicationContext(), "ID =" + ID + "PW = " + PW, Toast.LENGTH_LONG);
        temp.show();

        //최상단바 보이기
        MainTopBar mainTopBar = new MainTopBar();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, mainTopBar).commit();
    
    }
}