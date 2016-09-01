package com.jss.comparator;

import java.util.Comparator;

/**
 *
 */
public class Telephone extends Product implements Comparator<Telephone> {


    public Telephone() {

    }

    public Telephone(double price, String company, String model) {
        super(price, company, model);
    }

    @Override
    public int compare(Telephone o1, Telephone o2) {
//        if (o1.getPrice() > o2.getPrice()) {
//            return 1;
//        } else if (o1.getPrice() < o2.getPrice()) {
//            return -1;
//        }
        return 0;
    }
}
