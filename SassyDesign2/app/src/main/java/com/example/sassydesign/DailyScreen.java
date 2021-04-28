package com.example.sassydesign;

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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DailyScreen extends Fragment {

    TextView dailyOutcome;
    TextView dailyIncome;
    TextView dailyTotal;

    int totalIncome = 0;
    int totalOutcome = 0;
    int total = 0;

    ItemAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_daily_screen, container, false);

        //선언문
        String title = null;
        String cacheOrCard = null;
        ArrayList<String> itemList = new ArrayList<String>();
        ArrayList<String> categoryList = new ArrayList<String>();
        ArrayList<String> quantityList = new ArrayList<String>();
        ArrayList<String> priceList = new ArrayList<String>();


        dailyOutcome = rootView.findViewById(R.id.dailyOutcome);
        dailyIncome = rootView.findViewById(R.id.dailyIncome);
        dailyTotal = rootView.findViewById(R.id.dailyTotal);

        RecyclerView dailyReceiptList = rootView.findViewById(R.id.dailyReceiptList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        dailyReceiptList.setLayoutManager(layoutManager);
        itemAdapter = new ItemAdapter();

        Button handAddButton = rootView.findViewById(R.id.handAdd);
        handAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HandAddActivity.class);
                startActivity(intent);
            }
        });


        //데베에서 받아온 제목 넣기
        title = "제목";
        //데베에서 받아온 현금/카드 넣기
        cacheOrCard = "카드";
        //데베에서 받아온 물품 목록 넣기

        //튜플 개수 받아오기
        int cursor = 3;
        //튜플 개수만큼 반복

        setItemObject(title, cacheOrCard, itemList, categoryList, quantityList, priceList, cursor);
        dailyReceiptList.setAdapter(itemAdapter);

        //setTotal();

        return rootView;
    }


    public void setItemObject(String title, String cacheOrCard, ArrayList<String> itemList, ArrayList<String> categoryList,
                              ArrayList<String> quantityList, ArrayList<String> priceList, int cursor){
        String date = "";
        Item detailItem = null;

        for(int i = 0 ; i<2; i++){
            date = "3월20일";
            title = "제목";
            cacheOrCard = "카드";
            for (int j = 0 ; j < cursor ; j++){
                itemList.add(j,"냠냠굿 과자"+j);
                categoryList.add(j, "식비");
                quantityList.add(j, "1");
                priceList.add(j, "-3500");

            }
            detailItem = new Item(date, title, cacheOrCard, itemList,
                    categoryList, quantityList, priceList);
            detailItem.setCursor(cursor);
            itemAdapter.addItem(detailItem);

        }


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