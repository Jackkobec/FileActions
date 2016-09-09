package com.jss.com.jss.codingbat.recursion;

/**
 * Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
 * <p>
 * changePi("xpix") → "x3.14x"
 * changePi("pipi") → "3.143.14"
 * changePi("pip") → "3.14p"
 */
public class ChangePi {

    public String changePi(String str) {
        if (str.equals("")) {
            return "";
        }
        if (0 == str.length() || str.isEmpty()) {
            return null;
        }
        return str.replaceAll("pi", "3.14");

    }

}
