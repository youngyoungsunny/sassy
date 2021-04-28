package com.example.sassydesign;

import java.util.ArrayList;

public class Item {

    String date; //나중에 Date객체로 바꿀 예정!!!
    String title;
    String cacheOrCard;

    int cursor;

    ArrayList<String> itemList;
    ArrayList<String> priceList;
    ArrayList<String> categoryList;
    ArrayList<String> quantityList;

    public Item(String date, String title, String cacheOrCard,
                ArrayList<String> itemList, ArrayList<String>  categoryList,
                ArrayList<String>  quantityList, ArrayList<String>  priceList){
        this.date = date;
        this.title = title;
        this.itemList = itemList;

        this.priceList = priceList;
        this.cacheOrCard = cacheOrCard;
        this.quantityList = quantityList;
        this.categoryList = categoryList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCacheOrCard() {
        return cacheOrCard;
    }

    public void setCacheOrCard(String cacheOrCard) {
        this.cacheOrCard = cacheOrCard;
    }


    public ArrayList<String> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<String> getPriceList() {
        return priceList;
    }

    public void setPriceList(ArrayList<String> priceList) {
        this.priceList = priceList;
    }

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
    }

    public ArrayList<String> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(ArrayList<String> quantityList) {
        this.quantityList = quantityList;
    }

    public void setCursor(int cursor){
        this.cursor = cursor;
    }

    public int getCursor(){
        return cursor;
    }
}