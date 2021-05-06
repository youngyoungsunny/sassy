package com.example.sassydesign;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//회원가입 화면 액티비티
//sign_up.xml
public class SignupActivity extends AppCompatActivity {

    EditText signupID;
    EditText signupPW;
    EditText signupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        String ID ="";
        String PW = "";
        String Name = "";

        Button signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signupID = findViewById(R.id.signupID);
        signupPW = findViewById(R.id.signupPW);
        signupName = findViewById(R.id.signupName);

        //ID, PW, 이름 받은 변수들
        ID = signupID.getText().toString();
        PW = signupPW.getText().toString();
        Name = signupName.getText().toString();

    }

    public void OnClickHandler(View view){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //if문으로 아이디 중복 체크 후에 이 코드 들어가면 됨
        builder.setTitle("중복 체크").setMessage("사용 가능한 아이디입니다.");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        //중복일 때
//        builder.setTitle("중복 체크").setMessage("사용 불가능한 아이디입니다.");
//        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        alertDialog = builder.create();
//        alertDialog.show();
    }
}