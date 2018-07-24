package com.lzt.code;

public class SumTwoNumbers {


    static void sumTwoNumbers(int[] nums, int target) {
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <  size; j++) {
                count ++;
                int m = nums[i];
                int n = nums[j];
                if (m + n == target) {
                    System.out.println(i);
                    System.out.println(j);
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String args[]) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        sumTwoNumbers(nums, target);
    }

}
