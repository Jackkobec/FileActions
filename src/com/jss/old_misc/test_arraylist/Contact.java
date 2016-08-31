package com.jss.old_misc.test_arraylist;

import java.util.ArrayList;

/**
 *
 */
public class Contact {


    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact() {

    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String contactShow() {
        System.out.println(String.format("\nname: %s\nphoneNamber: %s ", name, phoneNumber
                + "\n------------------------"));
        return "";
    }

    public static void contactListShow(ArrayList<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }

    public static void contactListShowFirstFive(ArrayList<Contact> contactList) {
        for (int i = 0; i < 5; i++) {
            contactList.get(i).contactShow();
        }
    }

    public static void contactListShowLastFive(ArrayList<Contact> contactList) {
        for (int i = contactList.size() - 5 ; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }

    public ArrayList<Contact> removeByDelParam(ArrayList<Contact> contactList, String delParam) {
        for (int i = 0; i < contactList.size(); i++) {
            while (contactList.get(i).name.contains(delParam) || contactList.get(i).phoneNumber.contains(delParam)) {
                contactList.remove(i);
            }
        }
        return contactList;
    }

    public ArrayList<Contact> udateContactInfo(ArrayList<Contact> contactList, String updateParam) {
        for (int i = 0; i < contactList.size(); i++) {
            while (contactList.get(i).name.contains(updateParam) || contactList.get(i).phoneNumber.contains(updateParam)) {
                contactList.remove(i);
            }
        }
        return contactList;
    }


    public ArrayList<Contact> addToTheContactList(ArrayList<Contact> contactList, Contact contact){
        contactList.add(contact);
        return contactList;
    }





    public static void main(String[] args) {
        Contact contact1 = new Contact("Kola", "095 2323232");
        Contact contact2 = new Contact("Kola", "097 2323232");
        Contact contact3 = new Contact("Kola", "097 54545454");
        Contact contact4 = new Contact("Vasa", "097 54545454");
        Contact contact5 = new Contact();
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        //contact4.addToThtContactList(contactList, contact4);
        contact5.addToTheContactList(contactList, contact5);
        // contactListShow(contactList);

        // contactList.remove(0);
        // contactListShow(contactList);

        //contact1.removeByDelParam(contactList, "Kola");
        contactListShow(contactList);
        // System.out.println(contactList.get(0).contactShow());


    }
}




