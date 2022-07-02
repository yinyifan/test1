package com.yyf.demo;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];


        for (int i = 0; i < nums.length; i++) {

            int base = i;

            int minus = target - nums[base];

            if (Arrays.binarySearch(nums, minus) > 0) {

                result[0] = base;
                result[1] = i;
                return result;
            }


        }
        return result;
    }
}