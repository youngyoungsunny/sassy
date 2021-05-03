package com.example.sassydesign;

import android.content.Intent;
import android.os.Bundle;
//import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//회원가입 화면 액티비티
//sign_up.xml
public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Button signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}