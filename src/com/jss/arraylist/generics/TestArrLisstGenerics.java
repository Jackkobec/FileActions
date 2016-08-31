package com.jss.arraylist.generics;


/**
 * Test MultiArrayList
 */
public class TestArrLisstGenerics {
    public static void main(String[] args) {

        ArrayList<User> ar = new ArrayList();
        User us1 = new User("22", "Vasa");
        User us2 = new User("22", "Peta");
        User us3 = new User("24", "Sidor");

        ar.arrAdd(us1);
        ar.arrAdd(us2);
        ar.arrAdd(us3);
        System.out.println("Массив только с User:");
        System.out.println(ar);
        System.out.println("--------------------------------------------------");

        ArrayList<Integer> ar2 = new ArrayList();
        ar2.arrAdd(22);
        ar2.arrAdd(22);
        ar2.arrAdd(22);
        System.out.println("Массив только int:");
        System.out.println(ar2);
        System.out.println("--------------------------------------------------");

        ArrayList<String> ar3 = new ArrayList();
        ar3.arrAdd("Test");
        ar3.arrAdd("Test");
        ar3.arrAdd("Test");
        System.out.println("Массив только String:");
        System.out.println(ar3);
        System.out.println("--------------------------------------------------");

        ArrayList<Object> ar4 = new ArrayList();
        ar4.arrAdd(2);//запихнем int
        ar4.arrAdd("Test");//запихнем String
        ar4.arrAdd(5.0);//запихнем double
        ar4.arrAdd(us1);//запихнем User
        System.out.println("Массив в элементах которого лежат разные типы:");
        System.out.println(ar4);
        System.out.println("--------------------------------------------------");

        System.out.println("Напечатаем через геттер массив с разными типами:");
        System.out.println(ar4.getList());


    }
}