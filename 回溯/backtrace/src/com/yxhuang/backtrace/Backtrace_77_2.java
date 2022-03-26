package com.yxhuang.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * https://leetcode-cn.com/problems/combinations/
 *
 *  优化剪枝
 */
public class Backtrace_77_2 {
    private static LinkedList<Integer> mPath = new LinkedList<>();
    private static List<List<Integer>> mResult = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        for (List<Integer> item : combine) {
            for (int i : item) {
                System.out.print(i + "");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k > n){
            return null;
        }
        if (n == 1 && k == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<List<Integer>> result = new ArrayList<>();
            result.add(list);
            return result;
        }
        backtrace(n, k, 1);
        return mResult;
    }

    private static void backtrace(int n, int k, int startIndex) {
        // 以满足条件
        if (mPath.size() == k) {
            mResult.add(new ArrayList<>(mPath)); // 这里是要复制一个新的进去，而不是直接放进去
            return;
        }
        // 每一层的遍历， 剪枝优化
        for (int i = startIndex; i <= n - (k - mPath.size()) + 1; i++) {
            mPath.add(i);
            backtrace(n, k, i + 1);
            mPath.removeLast();
        }
    }
}
