package com.yxhuang.array.f1710;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int result = majorityElement(nums);
        System.out.println("result = " + result);

    }

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        int half = length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        int maxTimes = 0;
        int resultValue = 0;
        for (int i = 0; i < length; i++) {
            int value = nums[i];
            Integer tempValue = map.get(value);
            if (tempValue == null) {
                map.put(value, 1);
            } else {
                int times = tempValue + 1;
                map.put(value, times);
                if (times > maxTimes) {
                    maxTimes = times;
                    resultValue = value;
                }
            }
        }
        if (maxTimes >= half) {
            return resultValue;
        }
        return -1;
    }

}
