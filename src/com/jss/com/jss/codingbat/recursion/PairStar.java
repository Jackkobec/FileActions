package com.jss.com.jss.codingbat.recursion;

/**
 * Created by Стас on 09.09.2016.
 */
public class PairStar {

    public static void main(String[] args) {
        String str = "aaabaaaa";
        System.out.println(pairStarAlt(str));
        //System.out.println(pairStar(pairStar(str)));
    }


    public static String pairStar(String str) {
        if (str.equals("")) {
            return "";
        }
        if (0 == str.length() || str.isEmpty()) {
            return null;
        }
        String res = "";
        if (str.substring(0, 1).equals(str.substring(1, 2))) {
            res = str.replaceAll(str.substring(0, 2), (str.substring(0, 1) + "*" + str.substring(1, 2)));

        }
        return res;

    }

    public static String pairStarAlt(String str) {

        if (str.equals("")) {
            return "";
        }
        if (0 == str.length() || str.isEmpty()) {
            return null;
        }

        if (str.length() < 2) {
            return str;
        }
        return str.charAt(0)
                + (str.charAt(0) == str.charAt(1) ? "*" : "")
                + pairStar(str.substring(1));
    }
}
