package com.yxhuang.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  https://leetcode.cn/problems/subsets/
 */
public class Backtrace_78 {

    private static List<List<Integer>> sResult = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);

        for (List<Integer> list : sResult){
            for (int i : list){
                System.out.print(i + "");
            }
            System.out.println(" ");
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return Collections.emptyList();
        }
        sResult.clear();
        backtrace(nums, 0, new LinkedList<>());
        return sResult;
    }


    private static void backtrace(int[] nums, int startIndex, LinkedList<Integer> levePath){
        sResult.add(new ArrayList<>(levePath));
        // 终止条件
        if (startIndex >= nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++){
            levePath.add(nums[i]); // 注意这里是 i
            backtrace(nums, i + 1, levePath); //  这里是 i + 1
            // 回溯
            levePath.removeLast();
        }
    }
}
