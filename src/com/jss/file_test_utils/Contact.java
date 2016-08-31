package com.jss.file_test_utils;

import java.io.Serializable;

public class Contact implements Serializable  {
    public String name;
    public String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public void contactShow() {
        System.out.println(String.format("\nname: %s\nphoneNamber: %s ", name, phoneNumber
                + "\n------------------------"));
    }
}
