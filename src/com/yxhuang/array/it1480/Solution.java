package com.yxhuang.array.it1480;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};
        int[] result = runningSum(nums);
        for (Integer integer : result){
            System.out.println("integer " + integer);
        }

        int[] result2 = runningSum2(nums);
        for (Integer integer : result2){
            System.out.println("integer " + integer);
        }
    }


    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if (i == 0){
                result[0] = nums[0];
            } else  {
                result[i] = result[i -1] + nums[i];
            }
        }
        return result;
    }

    public static int[] runningSum2(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i -1] + nums[i];
        }
        return nums;
    }
}
