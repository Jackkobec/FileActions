package com.jss.com.jss.codingbat.recursion;

/**
 * CGiven a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
 * <p>
 * allStar("hello") → "h*e*l*l*o"
 * allStar("abc") → "a*b*c"
 * allStar("ab") → "a*b"
 */
public class AllStar {
    public String allStar(String str) {
        if (str.equals("")) {
            return "";
        }
        if (0 == str.length() || str.isEmpty()) {
            return null;
        }
        String res = (str.charAt(0) + "*" + allStar(str.substring(1)));
        if (res.endsWith("*")) {
            return res.substring(0, res.length() - 1);
        }
        return res;
    }

}
