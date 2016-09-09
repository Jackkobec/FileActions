package com.jss.com.jss.codingbat.recursion;

import java.util.Arrays;

/**
 * Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
 * <p>
 * array11([1, 2, 11], 0) → 1
 * array11([11, 11], 0) → 2
 * array11([1, 2, 3, 4], 0) → 0
 */
public class Array11 {
    public static void main(String[] args) {
        int[] mas = {11, 11, 0, 1};
        System.out.println(array11(mas, 0));
        System.out.println(array11alt(mas, 0));
    }

    //!!! codingbat dosent know what is System.arraycopy
    public static int array11(int[] nums, int index) {
        if (0 == nums.length) {
            return 0;
        }
        int count = 0;
        if (nums[0] == 11) {
            count++;
        }
        int[] ar2 = new int[nums.length - 1];
        System.arraycopy(nums, 1, ar2, 0, ar2.length);
        return count + array11(ar2, 0);
    }

    public static int array11alt(int[] nums, int index) {
        if (0 == nums.length) {
            return 0;
        }
        int count = 0;
        if (nums[0] == 11) {
            count++;
        }
        return count + array11(Arrays.copyOfRange(nums, 1, nums.length), 0);
    }
}