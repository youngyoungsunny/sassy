package com.example.sassydesign;

import android.widget.Spinner;

public class ItemDetail {
    String productName;
    String productCost;
    String productQuantity;
    String productCategory;
    Spinner category;
    int position;

    public ItemDetail(String productName, String productCost, String quantity, Spinner category) {
        this.productName = productName;
        this.productCost = productCost;
        this.productQuantity = quantity;
        this.category = category;

    }

//    public void setSpinner(Spinner category) {
//        this.category = category;
//    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }


    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Spinner getCategory() {
        return category;
    }

    public void setCategory(Spinner category) {
        this.category = category;
    }

    public void setSelectedCategory(int position){
        this.category.setSelection(position);
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
    }
}