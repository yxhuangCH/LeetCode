package com.yxhuang.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 * <p>
 * https://leetcode-cn.com/problems/uUsW3B/
 */
public class Backtrace_office_80 {

    private static List<List<Integer>> sResults = new ArrayList<>();

    public static void main(String[] args) {
        combine(4, 2);
        for (List<Integer> List : sResults) {
            for (int i : List) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return Collections.emptyList();
        }
        sResults.clear();
        combine2(n, k, 1, new LinkedList<>());
        return sResults;
    }

    /**
     *  第一种方式
     *  这种方法符合人的正常逻辑思维，先递归，再从 0 开始遍历
     * @param n
     * @param k
     * @param startIndex
     * @param path
     */
    public static void combine(int n, int k, int startIndex, LinkedList<Integer> path) {
        if (path.size() == k) {
            sResults.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            combine(n, k, i + 1, path);
            path.removeLast();
        }
    }

    /**
     * 第二种方式
     * @param n
     * @param k
     * @param startIndex
     * @param path
     */
    public static void combine2(int n, int k, int startIndex, LinkedList<Integer> path) {
        if (path.size() == k) {
            sResults.add(new ArrayList<>(path));
        } else if (startIndex <= n){
            System.out.println("startIndex: " + startIndex);
            combine2(n, k, startIndex + 1, path);

            System.out.println("add: " + startIndex);
            path.add(startIndex);
            combine2(n, k, startIndex + 1, path);
            int remove = path.removeLast();
            System.out.println("remove: " + remove);
        }
    }
}
