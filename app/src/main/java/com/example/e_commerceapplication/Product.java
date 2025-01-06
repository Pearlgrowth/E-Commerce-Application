package com.example.e_commerceapplication;

public class Product {
    private String productName;
    private String productImage;
    private double productPrice;
      // Use an int for the drawable resource ID

    public Product(String productName, double productPrice, String productImage) {
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }
    public String getProductImage() {
        return productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }


}
