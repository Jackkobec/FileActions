package com.jss.old_misc.validator_ex_old;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleValidator {
    public String name;
    public String phoneNumber;
  // public String email;
   // public String operatorLifeKievstar;
public void init(String name, String phoneNumber) {


        this.name = name;
        this.phoneNumber = phoneNumber;
       //his.email = email;


        if (!checkName()){
        System.out.println("Не правильно введено имя: " + name + " Для записи имени используйте символы a-z, A-Z, 0-9, _");
        }

        if (!checkPhoneNumber()){
        System.out.println("Не правильно введен номер телефона: " + phoneNumber + " Для записи номера используйте цифры 0-9. Пример 0937721749");
        }

//        if (!checkEmail()){
//        System.out.println("Не правильно введен email: " + email + " Пример piskun@gmail.com");
//        }

//        String str = phoneNumber.substring(0,3);
//        if (str.equals("063")||str.equals("093")||str.equals("073")){
//        operatorLifeKievstar = "Life";
//        } else if (str.equals("098")||str.equals("067")||str.equals("068")){
//        operatorLifeKievstar = "Kievstar";
//        } else operatorLifeKievstar = null;

        }

public boolean checkName() {
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{3,15}$");
        Matcher m = p.matcher(name);
        return m.matches();
        }

public boolean checkPhoneNumber() {

        Pattern p = Pattern.compile("^[\\s0-9]{12}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
        }
//
//public boolean checkEmail(){
//        Pattern p = Pattern.compile("^[A-Za-z0-9_]{3,8}\\@(gmail|ukr|mail)\\.(com|net|ru)$");
//        Matcher m = p.matcher(email);
//        return m.matches();
//        }

public String toStringContact(){
        return String.format("name: %s, phone: %s", name, phoneNumber);
        }

    public static void main(String[] args) {
ExampleValidator us = new ExampleValidator();
      us.init("Vasa", "jyhjhj");
        System.out.println(us.toStringContact());

    }
}