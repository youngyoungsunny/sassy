package com.example.sassydesign;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lib.kingja.switchbutton.SwitchMultiButton;

//사용자가 손으로 직접 추가하는 화면
//hand_add.xml
public class HandAddActivity extends AppCompatActivity {

    Button dateButton;
    Date selectedDate;
    Button itemDetailAddButton;
    SwitchMultiButton switchInOutButton;
    SwitchMultiButton switchCCButton;
    String inOrOut="";
    String cashCard ="";
    String title="";
    EditText itemDetailTitle;
    Button completeButton;

    public static Activity handAddActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hand_add);

        handAddActivity = HandAddActivity.this;

        //사용자가 입력한 제목 title로 받아오기
        itemDetailTitle = findViewById(R.id.itemDetailTitle);
        title = itemDetailTitle.getText().toString();

        //사용자가 선택한 수입/지출 inOrOut으로 받아오기
        switchInOutButton = findViewById(R.id.switchInOutButton);
        switchInOutButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                inOrOut = tabText;
            }
        });

        //사용자가 선택한 현금/카드 cashCard로 받아오기
        switchCCButton = findViewById(R.id.switchCCButton);
        switchCCButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                cashCard = tabText;
            }
        });

        //날짜 선택하는 버튼 누르면 선택된 날짜 selectedDate에 받아오기
        //selectedDate를 데베에 넣음
        dateButton = findViewById(R.id.dateButton);
        if (!((dateButton.getText().toString()).equals("날짜"))) {
            Date selectedDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
            String dateMsg = dateButton.getText().toString();
            try {
                selectedDate = simpleDateFormat.parse(dateMsg);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //리싸이클러뷰 선언, 초기화, 어댑터 초기화
        RecyclerView recyclerView = findViewById(R.id.handAddRecyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ItemDetailAdapter adapter = new ItemDetailAdapter();

        //예시로 넣은 상세 품목들
        adapter.addItem(new ItemDetail("과자", "1500", "1","식비"));
        adapter.addItem(new ItemDetail("음료수", "2500","2","식비"));
        adapter.addItem(new ItemDetail("커피", "3000", "3","식비"));

        recyclerView.setAdapter(adapter);

        //@@@@@@@@@@아래부터 데베가 할 일@@@@@@@@@@
        //완료버튼 누르면 데이터베이스에 전송
        completeButton = findViewById(R.id.completeButton);
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i< adapter.getItemCount(); i++) {
                    //상세 품목 객체 하나를 tmp에 받아옴
                    ItemDetail tmp = adapter.parsingData(i);
                    //tmp의 get함수로 받아서 데베에 넣기
                    String productName = tmp.getProductName();
                    String productCost = tmp.getProductCost();
                    String productQuantity = tmp.getProductQuantity();
                    String selectedCategory =  tmp.getProductCategory();
                }

                //위에서 받아온 수입지출, 카드현금, 날짜, 제목 데베에 넣기




                //액티비티 종료(건들면 안 됨)
                HandAddActivity HA = (HandAddActivity) HandAddActivity.handAddActivity;
                HA.finish();
            }
        });


        //+버튼 누르면 상세 품목 작성 칸 추가
        itemDetailAddButton = findViewById(R.id.itemDetailAddButton);
        itemDetailAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDetail itemDetail = null;
                //기본 수량을 1로 설정
                itemDetail = new ItemDetail("", "", "1", "");

                adapter.addItem(itemDetail);
                recyclerView.setAdapter(adapter);
            }
        });


        //날짜버튼 누르면 날짜선택(이 아래부터 건들면 안 됨)
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(v);
            }
        });

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "/" + month_string+"/"+day_string);
        dateButton.setText(dateMessage);

    }


}