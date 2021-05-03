package com.example.sassydesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//로그인 화면 액티비티
//log_in.xml
public class LoginActivity extends AppCompatActivity {

    public static Activity activity;

    EditText LoginID;
    EditText LoginPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        activity = LoginActivity.this;

        LoginID = findViewById(R.id.LoginID);
        LoginPW = findViewById(R.id.LoginPW);


        Button SingUpButton = findViewById(R.id.SignUpButton);
        SingUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        Button LoginButton = findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = LoginID.getText().toString();
                String PW = LoginPW.getText().toString();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("ID", ID);
                intent.putExtra("PW", PW);
                setResult(RESULT_OK, intent);
                startActivity(intent);
            }
        });

    }
}