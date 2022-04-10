package com.yxhuang.backtrace;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 *  https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Backtrace_40{

    private static List<List<Integer>> sResult = new ArrayList<>();

    private static int sBack;

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;

        combinationSum2(candidates, target);
        for (List<Integer> item : sResult) {
            for (int i : item) {
                System.out.println(i);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0 || target == 0){
            return Collections.emptyList();
        }
        sResult.clear();
        // 先要排序
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, new LinkedList<>());
        return sResult;
    }

    private static void backtrace(int[] candidates, int remainTarget, int startIndex, LinkedList<Integer> levelResult){
        if (remainTarget < 0){
            return;
        }
        if (remainTarget == 0){
            sResult.add(new ArrayList<>(levelResult));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++){
            int value = candidates[i];
            int nextTarget = remainTarget - value;
            if (nextTarget < 0){
                break;
            }

            //难点： 要对同⼀树层使⽤过的元素进⾏跳过
            if ( i > startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
//            if (value == sBack){
//                continue;
//            }

            levelResult.add(value);
            backtrace(candidates, nextTarget,  i + 1, levelResult);
            levelResult.removeLast();
//            sBack =  levelResult.removeLast();
        }

    }
}
