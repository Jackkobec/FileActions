package com.jss.old_misc.homeWork1;

import java.util.Scanner;

/**
 * Created by Стас on 06.08.2016.
 */
public class UserUtils {
    public static String userToString(User user) {
        return String.format("name: %s,\njob: %s,\nage: %d,\nsalary: %s \n",
                user.name, user.job, user.age, user.salary);
    }

    public static String listAll(User[] users) {
        String resultString = "";
        for (int i = 0; i < users.length; i++) {
            User user1 = users[i];
            resultString += (user1 != null ? userToString(user1) + "\n" : "");

        }
        return resultString;
    }

    public static String addUser() {
        Scanner sc = new Scanner(System.in);
        User user6 = new User();
        System.out.print("Enter user name: ");
        user6.name = sc.nextLine();
        System.out.print("Enter user job: ");
        user6.job = sc.nextLine();
        System.out.print("Enter user age: ");
        user6.age = sc.nextInt();
        System.out.print("Enter user salary: ");
        user6.salary = sc.nextDouble();
        String new_user = userToString(user6);
        return new_user;
    }

    public static int userCounter(User[] users) {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            count++;
        }
        return count;
    }
}