package com.yxhuang.array.offer_053;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        int missingNumber = missingNumber(nums);
        System.out.println("missingNumber :" + missingNumber);

    }

    private static int missingNumber(int[] nums) {
        int lenght = nums.length;
        if (nums.length == 1){
            if (nums[0] == 0){
                return 1;
            } else if (nums[0] == 1){
                return 0;
            }
            return -1;
        }


        int low = 0;
        int hight = lenght -1;
        while (low <= hight){
            int mid = (low + hight) / 2;

            int midLowValue = nums[mid -1];
            int midHightValue = nums[mid + 1];
            int midValue = nums[mid];
            if (midLowValue + 1 != midValue){
                return midLowValue + 1;
            }

            if (midHightValue -1 != midValue ){
                return midHightValue -1;
            }


        }

        return -1;
    }

    private static int bsearch(int[] nums, int low, int high){
        while (low <= high){
            int mid = (low + high) / 2;

            int midLowValue = nums[mid -1];
            int midHightValue = nums[mid + 1];
            int midValue = nums[mid];
            if (midLowValue + 1 != midValue){
                return midLowValue + 1;
            }

            if (midHightValue -1 != midValue ){
                return midHightValue -1;
            }
        }
        return 0;
    }

}
