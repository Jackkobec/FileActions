package com.jss.old_misc.test_getters_and_setters;

/**
 * Created by Стас on 13.08.2016.
 */
public class TestContactList {
    public static void main(String[] args) {
        ContactList list = new ContactList();
        System.out.println(list.getContactName());
        System.out.println(list.ddddd());
        list.chengeNameOfContact("Petya");
        System.out.println(list.getContactName());
    }
}
