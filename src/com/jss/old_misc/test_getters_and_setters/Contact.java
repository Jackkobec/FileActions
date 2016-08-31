package com.jss.old_misc.test_getters_and_setters;

/**
 * Created by Стас on 13.08.2016.
 */
public class Contact {
    public Contact(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;
}
