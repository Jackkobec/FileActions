package com.jss.old_misc.test_getters_and_setters;

/**
 * Created by Стас on 13.08.2016.
 */
public class ContactList {
    Contact contact = new Contact("Vasan");

    public String getContactName() {

        return contact.getName();
    }

    public String ddddd() {

        return this.getContactName();
    }
    public void chengeNameOfContact(String name){

         contact.setName(name);
    }

}
