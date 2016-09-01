package com.jss.comparator;

import java.util.Comparator;

/**
 *
 */
public class Product {
    private double price;
    private String company;
    private String model;

    public Product() {

    }


    public Product(double price, String company, String model) {
        this.price = price;
        this.company = company;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", company='" + company  +
                ", model='" + model + '\n';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
