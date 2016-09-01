package com.jss.comparator;

import java.util.Comparator;

/**
 * Created by Стас on 02.09.2016.
 */
public class Camera extends Product implements Comparator<Product> {

    public Camera() {
    }

    public Camera(double price, String company, String model) {
        super(price, company, model);
    }

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }
}
