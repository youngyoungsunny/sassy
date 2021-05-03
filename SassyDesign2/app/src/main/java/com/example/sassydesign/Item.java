package com.example.sassydesign;

import java.util.ArrayList;
import java.util.Date;

public class Item {

    Date date;
    String title;
    String cacheOrCard;
    
    int subCursor;

    ArrayList<String> itemList;
    ArrayList<String> priceList;
    ArrayList<String> categoryList;
    ArrayList<String> quantityList;

    public Item(Date date, String title, String cacheOrCard,
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSubCursor(int subCursor){
        this.subCursor = subCursor;
    }

    public int getSubCursor(){
        return subCursor;
    }
}