package com.jss.passwordGenerate;

import java.util.Random;

public class RandomPaswordForUser {

    //Набір символів з яках має генеруватися віпадковий пароль. Представлений у масиві чарів.
    /*char[] correctPasswordCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',};*/
    /**
     * Генератор случайного пароля
     **/
  /*  public static String genPassword(char[] chars, int lenght) {
        Random rand = new Random();
        StringBuilder randomPasword = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            randomPasword.append(chars[rand.nextInt(chars.length)]);
        }

        return randomPasword.toString();*/

    /**
     * Генератор случайного пароля со статической приставкой PREFIX_ , очень удобно для рекламы или для создания более
     * красивого пароля
     **/
    public static String genPassword(char[] chars, int lenght) {
        Random rand = new Random();
        StringBuilder randomPasword = new StringBuilder("PREFIX_");
        for (int i = 0; i < lenght; i++) {
            randomPasword.append(chars[rand.nextInt(chars.length)]);
        }

        return randomPasword.toString();
    }


}
