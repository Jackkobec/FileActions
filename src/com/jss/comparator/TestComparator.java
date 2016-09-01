package com.jss.comparator;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Test Comparator
 */
public class TestComparator {
    public static void main(String[] args) {
        //This Comparator returns Product sorted sorted by company name and price from low to high
        Comparator<Product> compPr = new PruductCompanyComporator().thenComparing(new ProductPriceComparator());
        //Create TreeSet with our Comparator
        TreeSet<Product> products = new TreeSet(compPr);

        Telephone tel1 = new Telephone();
        tel1.setPrice(10000);

        tel1.setCompany("Samsung");
        Telephone tel12 = new Telephone();

        tel12.setPrice(20000);
        tel12.setCompany("Dell");

        Telephone tel3 = new Telephone(1000, "Samsung", "wedfe3f");
        Telephone tel4 = new Telephone(4646, "Dell", "wedfe3f");
        Telephone tel5 = new Telephone(1034300, "Samsung", "wedfe3f");
        Telephone tel7 = new Telephone(106400, "Dell", "wedfe3f");

        Camera cam1 = new Camera(1000, "Sony", "wedfe3f");

        products.add(cam1);

        products.add(tel1);
        products.add(tel12);
        products.add(tel3);
        products.add(tel3);
        products.add(tel4);
        products.add(tel5);
        products.add(tel7);

        //As we can see, sorting successful
        System.out.println(products);
    }
}
