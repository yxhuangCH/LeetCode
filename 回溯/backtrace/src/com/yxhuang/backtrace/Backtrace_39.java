package com.yxhuang.backtrace;

import java.util.*;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class Backtrace_39 {

    private static List<List<Integer>> sResult = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        // 剪枝的前提是有序数组
        Arrays.sort(candidates);
        combinationSum(candidates, target);
        for (List<Integer> item : sResult) {
            for (int i : item) {
                System.out.println(i);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return Collections.emptyList();
        }
        sResult.clear();
        backtrace(candidates, target, 0,  new LinkedList<>());
        return sResult;
    }

    /**
     *
     * @param candidates
     * @param remainTargetValue
     * @param startIndex
     * @param path
     *
     *
     */
    private static void backtrace(int[] candidates, int remainTargetValue, int startIndex, LinkedList<Integer> path) {
        if (remainTargetValue < 0) {
            return;
        }

        // 当剩余值为 0 时，说明已经找到组合
        if (remainTargetValue == 0) {
            sResult.add(new ArrayList<>(path));
            return;
        }

        // 难点在用如何确定下一遍历的起点 startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            int value = candidates[i];
            // 剪枝
            if (remainTargetValue - value < 0){
                break;
            }
            path.add(value);
            int remainValue = remainTargetValue - value;
            backtrace(candidates, remainValue, i, path);
            path.removeLast();
        }
    }

}
