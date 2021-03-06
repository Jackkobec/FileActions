package com.jss.comparator;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Test Comparator and Comparable
 */
public class TestComparator {
    public static void main(String[] args) {
        /**
         * Test Comparator
         */
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
        System.out.println("==================================");
        /**
         * Test Comparable
         */
        FlashMemory fm1 = new FlashMemory(200, "Trancend", "any");

        FlashMemory fm2 = new FlashMemory(222, "Kingsdon", "any");
        FlashMemory fm3 = new FlashMemory(333, "Trancend", "any");
        FlashMemory fm4 = new FlashMemory(444, "Trancend", "any");
        //! Почему то compareTo когда возвращает, что имя компании одинаково - не добавляет в TreeSet
        // ПОТОМУ ЧТО TreeSet МОЖЕТ ХРАНИТЬ РАЗНЫЕ ЗНАЧЕНИЯ , А МЫ ЗХАДАЛИ АЛГОРИТМ СРАВНЕНИЯ ТОЛЬКО ПО ИМЕНИ КОМПАНИИ
        // И КОГДА ИМЯ ОДИНАКОВОЕ TreeSet НЕ ДОБАВЛЯЕТ В СЕБЯ ОБЪЕКТ!
        TreeSet<FlashMemory> flashki = new TreeSet<>();
        flashki.add(fm1);
        flashki.add(fm2);
        flashki.add(fm3);
        flashki.add(fm4);

        System.out.println(flashki);
    }
}
