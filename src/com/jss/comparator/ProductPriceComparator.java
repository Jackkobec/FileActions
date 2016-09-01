package com.jss.comparator;

import java.util.Comparator;

/**
 *Compare by price from little to high
 */
public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if(o1.getPrice() < o2.getPrice()){
            return -1;
        }
        return -0;
    }
}