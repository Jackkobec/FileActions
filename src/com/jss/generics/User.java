package com.jss.generics;

import java.util.Random;


/**
 * User class for test
 */
public class User {
    private final String id;
    private final int age;
    private final String name;


    public User(int age, String name) {
        this.id = idGenerator();
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String idGenerator() {
        int lenght = 7;
        char[] correctChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random rand = new Random();
        StringBuilder randomID = new StringBuilder("USER_");
        for (int i = 0; i < lenght; i++) {
            randomID.append(correctChars[rand.nextInt(correctChars.length)]);
        }

        return randomID.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
