package com.jss.comparator;

import java.util.Comparator;

/**
 * Compare by name
 */
class PruductCompanyComporator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}
