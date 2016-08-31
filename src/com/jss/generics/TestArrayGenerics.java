package com.jss.generics;

import java.util.Scanner;

/**
 * Test Array Generic
 */
public class TestArrayGenerics {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        String age = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        int ageInt = Integer.parseInt(age);

        User user1 = new User(ageInt, name);
        User user2 = new User(22, "Vasa");
        User user3 = new User(23, "Petya");



        ArrayGenerics<User> arrGen = new ArrayGenerics(3);

        arrGen.add(user1);
        arrGen.add(user2);
        arrGen.add(user3);

        System.out.println(arrGen);



    }
}
