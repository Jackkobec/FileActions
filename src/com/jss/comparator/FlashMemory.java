package com.jss.comparator;

/**
 * Comparable FlashMemory
 */
public class FlashMemory extends Product implements Comparable<FlashMemory> {

    public FlashMemory() {
    }

    public FlashMemory(double price, String company, String model) {
        super(price, company, model);
    }

    @Override
    public int compareTo(FlashMemory o) {
        return this.getCompany().compareTo(o.getCompany());
    }
}