package com.jss.file_test_utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TestSerial implements Serializable {
    //    public String[] name = {"Vasa","sssssss"};
//    public String phoneNumber = "0";
    public List<Contact> contactList = new ArrayList<>();


    public static void main(String args[]) throws IOException, ClassNotFoundException {
        TestSerial list = new TestSerial();
        Contact contact1 = new Contact("Vasa", "3333333");
        Contact contact2 = new Contact("Petua", "3333333");
        list.addToTheContactList(contact1);
        list.addToTheContactList(contact2);

        // list.contactListShow();
        list.teleport();

        //replicate

        list.replicate();


    }

    public void contactListShow() {
        for (int i = 0; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }

    public void contactListShow(List<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }

    public boolean addToTheContactList(Contact contact) {
        return contactList.add(contact);
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    private void teleport() throws IOException, FileNotFoundException {

        String fileName = "D://ContactList.txt";
        File file = new File(fileName);


        //проверяем, что если файл не существует то создаем его
        if (!file.exists()) {
            file.createNewFile();
        }


        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.flush();
        oos.close();


    }

    private void replicate() throws IOException, ClassNotFoundException {
        String fileName = "D://ContactList.txt";
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream oin = new ObjectInputStream(fis);
        TestSerial ts = (TestSerial) oin.readObject();
        ts.contactListShow(ts.contactList);

    }


    public static void listShow(List<Contact> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name);
        }
    }

}