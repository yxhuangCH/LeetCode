package com.yxhuang.one_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *  key 是只， value 是 index
 */
public class Client {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 26;
        int[] result = twoSum(nums, target);
        if (result == null){
            System.out.println("Error");
        } else {
            for (Integer integer : result){
                System.out.println("result " + integer);
            }
        }

    }

    public static int[] twoSum(int[] nums, int target) throws Exception {
        int length = nums.length;
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < length; i++){
            int valueOne = nums[i];
            int valueTwo = target - valueOne;
            if (tempMap.containsKey(valueTwo)){
               return new int[]{tempMap.get(valueTwo), i};
            } else {
                tempMap.put(valueOne, i);
            }
        }
        return null;
    }
}
