package com.jss.com.jss.codingbat.recursion;

/**
 * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
 * <p>
 * countX("xxhixx") → 4
 * countX("xhixhix") → 3
 * countX("hi") → 0
 */
public class CountX {
    public int countX(String str) {
        if (0 == str.length()) {
            return 0;
        }
        int count = 0;
        if (str.substring(0, 1).equalsIgnoreCase("x")) {
            count++;
        }
        return count + countX(str.substring(1, str.length()));
    }
}
