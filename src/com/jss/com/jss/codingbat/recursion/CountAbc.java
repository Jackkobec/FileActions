package com.jss.com.jss.codingbat.recursion;

/**
 * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
 * <p>
 * countAbc("abc") → 1
 * countAbc("abcxxabc") → 2
 * countAbc("abaxxaba") → 2
 */
public class CountAbc {


    public int countAbc(String str) {
        if (str.length() < 3) {
            return 0;
        }
        if (str.equals("")) {
            return 0;
        }
        if (0 == str.length() || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba")) {
            count++;
            return count + countAbc(str.substring(1));
        } else {
            return countAbc(str.substring(1));
        }
    }

}
