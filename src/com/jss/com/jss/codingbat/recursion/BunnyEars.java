package com.jss.com.jss.codingbat.recursion;

/**
 * We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
 * <p>
 * bunnyEars(0) → 0
 * bunnyEars(1) → 2
 * bunnyEars(2) → 4
 */
public class BunnyEars {
    public int bunnyEars(int bunnies) {
        if (0 == bunnies) {
            return 0;
        }
        return bunnies * 2;
    }

}
