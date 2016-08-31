package com.jss.old_misc.homeWork1;

import static homeWork1.RemoveUtils.removeByEnteredName;
import static homeWork1.UserUtils.*;

public class TestUser {
    public static void main(String[] args) {
        User user1 = new User();
        user1.name = "Vasa";
        user1.job = "SysAdm";
        user1.age = 20;
        user1.salary = 15000.0;

        User user2 = new User();
        user2.name = "Petya";
        user2.job = "QA";
        user2.age = 21;
        user2.salary = 15000.0;

        User user3 = new User();
        user3.name = "Inokentiy";
        user3.job = "Dev";
        user3.age = 21;
        user3.salary = 25000.0;

        User user4 = new User();
        user4.name = "Kolia";
        user4.job = "Lead";
        user4.age = 22;
        user4.salary = 80000.0;

        User user5 = new User();
        user5.name = "Tolya";
        user5.job = "Trainee";
        user5.age = 18;
        user5.salary = 7000.0;


        User[] users = new User[10];

        users[0] = user1;
        users[1] = user2;
        users[2] = user3;
        users[3] = user4;
        users[4] = user5;

        System.out.println("Отработал метод userToString:");
        System.out.println(userToString(user1));
        System.out.println("Отработал метод listAll:");
        System.out.println(listAll(users));
        System.out.println("Отработал метод userCounter:");
        System.out.println("максимальное количество юзеров:" + userCounter(users));
        System.out.println();
        System.out.println("Отрабатывает метод addUser:");
        System.out.println(addUser());
        System.out.println("Отрабатывает метод removeByEnteredName:");
        System.out.println(removeByEnteredName(users));
    }
}
/**
 * int n = 5;
 * User[] users = new User[n];
 * users[0] = user1;
 * users[1] = user2;
 * //  users[2] = user3;
 * //   users[3] = user4;
 * //   users[4] = user5;
 **/