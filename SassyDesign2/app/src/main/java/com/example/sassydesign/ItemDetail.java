package com.example.sassydesign;

public class ItemDetail {
    String productName;
    String productCost;
    String productCategory;
    String productQuantity;


    public ItemDetail(String productName, String productCost, String quantity, String productCategory) {
        this.productName = productName;
        this.productCost = productCost;
        this.productQuantity = quantity;
        this.productCategory = productCategory;

    }

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
}
