package com.jss.passwordGenerate;

import java.util.Random;
import java.util.Scanner;

import static com.jss.passwordGenerate.RandomPaswordForUser.genPassword;

/**
 * Завдання: Написати інтерактивну програму для взаємодії з юзером. Юзер вводить своє ім'я і пароль.
 * Пароль має бути довжиною 8 - 20 символів і не містити слів: 'password', 'pass', 'gfhjkm',
 * У разі не відповідності введеного паролю до критеріїв -  генеруємо випадковий пароль
 * довжиною 8 - 20 із символів: a-z A-Z 0-9
 **/

public class UserInitialize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Юзер вводить своє ім'я
        System.out.print("Enter your name: ");
        String userName = sc.next();
        System.out.printf("Hi, %s!", userName);
        System.out.println();

        //Юзер вводить свый пароль
        String password = enterPasswordFromUser();

        //Перевырка паролю на довжину от 8 до 20 символів і наявність забороненіх слів методом passwordChecker
        System.out.println(passwordChecker(password) == true ? "Password correct: "
                + password : "");

        //Сгоден чи юзер з паролем yes / no?
        userLikePasword();
    }

    /**
     * Метод для введення юзером паролю
     **/
    public static String enterPasswordFromUser() {
        System.out.print("Enter your password: ");
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        return password;
    }

    /**
     * Метод для перевірки - чи подобається юзеру його правильно введений пароль або сгенерований випадково
     **/
    public static void userLikePasword() {
        System.out.print("Do you like your password(yes / no)?: ");
        Scanner sc2 = new Scanner(System.in);
        String answer = sc2.next();
        //Якщо юзеру не повобається пароль, то йому знову провонується ввести новий пароль, який теж буде перевірений
        if (answer.equalsIgnoreCase("no")) {
            String password = enterPasswordFromUser();
            System.out.println(passwordChecker(password) == true ? "Password correct: "
                    + password : "");
            userLikePasword();
        } else {
            System.out.println("Goodbye:)");

        }
    }

    /**
     * Метод для перевірки  паролю на відповідність крітеріям і у разі не відповідності генерація випадкового
     **/

    public static Boolean passwordChecker(String password) {
        //Дозволені символи для генерації випадкового паролю
        char[] correctPasswordCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',};
        Random rand = new Random();
        //Генератор випадкової довжени пароля від 8 до 20 символів
        int passworsLenhth = (8 + rand.nextInt(12));
        Boolean checkPasswordResult = false;
        //Перевірка введеногшо паролю на корректність: довжина 8 - 20 символів, та на наявність заборонених слів
        if (password.length() <= 8 || password.length() >= 20 || password.contains("pass")
                || password.contains("password") || password.contains("gfhjkm")) {
            System.out.println("Incorrect password!");
            System.out.println("Random Password For You: " + genPassword(correctPasswordCharacters, passworsLenhth));
        } else checkPasswordResult = true;
        return checkPasswordResult;

    }
}





