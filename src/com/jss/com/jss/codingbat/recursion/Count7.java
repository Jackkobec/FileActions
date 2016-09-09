package com.jss.com.jss.codingbat.recursion;

/**
 * Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
 * <p>
 * count7(717) → 2
 * count7(7) → 1
 * count7(123) → 0
 */
public class Count7 {
    public int count7(int n) {
        if (0 == n / 7) {
            return 0;
        }
        int count = 0;
        if (n % 10 == 7) {
            count++;
        }
        return count + count7(n / 10);

    }

}
