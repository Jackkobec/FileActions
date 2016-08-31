package com.jss.generics;

import java.util.Arrays;

/**
 * Created by Стас on 31.08.2016.
 */
public class ArrayGenerics<T> {
    private T[] array;
    private int size;


    public ArrayGenerics(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T el) {
        if (size == array.length) {
            throw new ArrayStoreException("array is full");
        }
        array[size++] = el;
    }

    private void test() {
        //T el = new Object();
        Object o = array[0];
    }


    private static void testStat() {
        // T el;
    }

    public int size() {
        return size;
    }

    public void set(int index, T el) {

    }

    public int indexOf(T el) {
        return -1;
    }

    @Override
    public String toString() {
        return "ArrayGenerics{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
