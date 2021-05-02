package com.example.sassydesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class MainTopBar extends Fragment {

    MainSecondBar mainSecondBar;
    CategoryScreen categoryScreen;
    CashOrCardScreen cashOrCardScreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.main_top_bar, container, false);

        TabLayout mainTabs = rootView.findViewById(R.id.mainTop);
        mainTabs.addTab(mainTabs.newTab().setText("날짜별"));
        mainTabs.addTab(mainTabs.newTab().setText("카테고리별"));
        mainTabs.addTab(mainTabs.newTab().setText("현금/카드별"));

        mainSecondBar = new MainSecondBar();
        categoryScreen = new CategoryScreen();
        cashOrCardScreen = new CashOrCardScreen();

        getFragmentManager().beginTransaction().replace(R.id.mainTopBarContainer, mainSecondBar).commit();

        mainTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0){
                    selected = mainSecondBar;
                }
                else if(position == 1){
                    selected = categoryScreen;
                }
                else if(position == 2){
                    selected = cashOrCardScreen;
                }

                getFragmentManager().beginTransaction().replace(R.id.mainTopBarContainer, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        return rootView;
    }

}
