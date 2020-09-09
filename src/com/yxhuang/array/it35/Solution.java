package com.yxhuang.array.it35;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int value = 2;
        int result = solution(nums, value);
        System.out.println("result " + result);
    }

    private static int solution(int[] nums, int value) {
        int low = 0;
        int height = nums.length - 1;
        while (low <= height) {
            int mid = low + ((height - low) >> 1);
            if (nums[mid] == value){
                return mid;
            }else if (nums[mid] > value) {
                height = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            }
        }
        return low;

    }
}
