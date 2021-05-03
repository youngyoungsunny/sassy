package com.example.sassydesign;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//일일 조회 화면
//daily_screen.xml
public class DailyScreen extends Fragment implements DatePickerDialog.OnDateSetListener {

    RecyclerView dailyReceiptList;

    TextView dailyOutcome;
    TextView dailyIncome;
    TextView dailyTotal;

    int totalIncome = 0;
    int totalOutcome = 0;
    int total = 0;

    ItemAdapter itemAdapter;

    Button dailyDateButton;
    String initDate="";
    Date todayDate;
    long now = System.currentTimeMillis();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.daily_screen, container, false);

        //초기화문
        dailyOutcome = rootView.findViewById(R.id.dailyOutcome);
        dailyIncome = rootView.findViewById(R.id.dailyIncome);
        dailyTotal = rootView.findViewById(R.id.dailyTotal);
        dailyDateButton = rootView.findViewById(R.id.dailyDateButton);

        //오늘 날짜 가져와서 설정
        todayDate = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        initDate = sdf.format(todayDate);
        dailyDateButton.setText(initDate);

        //리사이클러 뷰 선언, 설정, 어댑터 초기화
        dailyReceiptList = rootView.findViewById(R.id.dailyReceiptList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        dailyReceiptList.setLayoutManager(layoutManager);
        itemAdapter = new ItemAdapter();

        //추가 버튼(+) 눌렀을 때
        Button handAddButton = rootView.findViewById(R.id.handAdd);
        handAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handAdd 화면 출력
                Intent intent = new Intent(getActivity(), HandAddActivity.class);
                startActivity(intent);
            }
        });

        //@@@@@@@@@@밑에서부터 데베에서 할 일@@@@@@@@@@
        //밑에 setItemObject()함수로 가기
        setItemObject();
        dailyReceiptList.setAdapter(itemAdapter);


        //날짜 버튼 눌러서 날짜 선택하기
        dailyDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(v);
            }
        });

        //합계 지출, 수입은 데베 연결 후 작업할게
        //setTotal();

        return rootView;
    }


    public void setItemObject(){
        //선언문
        //제목
        String title = "";
        //현금/카드
        String cacheOrCard = "";
        //상세 품목 이름들을 담은 리스트
        ArrayList<String> itemList = new ArrayList<String>();
        //상세 품목 카테고리들을 담은 리스트
        ArrayList<String> categoryList = new ArrayList<String>();
        //상세 품목 수량들을 담은 리스트
        ArrayList<String> quantityList = new ArrayList<String>();
        //상세 품목 가격들을 담은 리스트
        ArrayList<String> priceList = new ArrayList<String>();

        //2 대신 튜플 개수 받아오기
        //여기서 2는 상세 품목 여러 개를 포함한(제목, 날짜, 상세 품목 이름들, 상세 품목 카테고리들
        //등등을 포함한) 전체 튜플의 개수
        int cursor = 2;
        //3대신 상세 품목들 개수 받아오기
        int subCursor = 3;
        //사용자가 선택한 날짜를 Date객체로 변환
        Date selectedDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
        try {
            selectedDate = simpleDateFormat.parse(initDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //item객체 생성할 null 객체
        Item detailItem = null;

        for(int i = 0 ; i<cursor; i++){
            //"제목" 대신 데베에서 가져온 제목 가져오기
            title = "제목";
            //"카드" 대신 데베에서 가져온 현금/카드 가져오기
            cacheOrCard = "카드";
            for (int j = 0 ; j < subCursor ; j++){
                //"냠냠굿 과자"대신 상세 품목 이름 가져오기
                itemList.add(j,"냠냠굿 과자"+j);
                //"식비"대신 상세 품목 카테고리 가져오기
                categoryList.add(j, "식비");
                //"1"대신 상세 품목 수량 가져오기
                quantityList.add(j, "1");
                //"-3500"대신 상세 품목 가격 가져오기
                priceList.add(j, "-3500");

            }
            //하나의 제목, 현금/카드, 날짜와 상세품목 이름들, 카테고리들, 수량들, 가격들을
            //하나의 아이템 객체로 만듦(여기 건들일 필요 없음)
            detailItem = new Item(selectedDate, title, cacheOrCard, itemList,
                    categoryList, quantityList, priceList);
            detailItem.setSubCursor(subCursor);
            itemAdapter.addItem(detailItem);

        }

    }

    //
    public void showDatePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        initDate = year + "년" + (month+1) + "월" + day + "일";
        dailyDateButton.setText(initDate);
        itemAdapter.removeItem();
        setItemObject();
        dailyReceiptList.setAdapter(itemAdapter);
    }




//    public void setTotal(){
//        dailyOutcome.setText(""+totalOutcome);
//        dailyIncome.setText("+"+totalIncome);
//
//        total = totalIncome + totalOutcome;
//        if (total>0)
//        {
//            dailyTotal.setText("+" + total);
//        }
//        else
//        {
//            dailyTotal.setText(""+total);
//        }
//    }
}