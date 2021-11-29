package com.example.lab.product;

public class product {

    int ID;
    String ProductName;
    int Price;

    public product(){}

    public product(int ID, String productName, int price) {
        this.ID = ID;
        ProductName = productName;
        Price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
