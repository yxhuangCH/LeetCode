package com.yxhuang.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 79 所有子集
 * 剑指 Offer II 079. 所有子集
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * https://leetcode-cn.com/problems/TVdhkn/
 */
public class Backtrace_office_79 {

    private static List<List<Integer>> sResults = new ArrayList<>();

    public static void main(String[] args) {
        sResults.clear();
        int[] origins = {1, 2, 3};
        allCombin(origins, 0, new LinkedList<>());
        for (List<Integer> List: sResults){
            for (int i : List){
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    /**
     * 解法 1
     * @param orgigins
     * @param startIndex
     * @param subsets
     */
    private static void allCombin(int[] orgigins, int startIndex,  LinkedList<Integer> subsets){
        sResults.add(new ArrayList<>(subsets)); // 收集子集，要放在终止添加的上面，否则会漏掉自己
        if (startIndex >= orgigins.length){ // 终止条件可以不加
            return;
        }

        for (int i = startIndex; i < orgigins.length; i++){
            subsets.add(orgigins[i]);
            allCombin(orgigins, i + 1, subsets);
            subsets.removeLast();
        }
    }

    /**
     *  解法 2
     * @param orgigins
     * @param startIndex
     * @param subsets
     */
    private static void allCombin2(int[] orgigins, int startIndex,  LinkedList<Integer> subsets){
        if (orgigins.length == startIndex){
            sResults.add(new ArrayList<>(subsets));
        } else if (startIndex < orgigins.length){
            // 不加入的情况，不对子集做任何操作，只需要处理下个数字（startIndex + 1）
            allCombin2(orgigins, startIndex + 1, subsets);

            // 加入的情况
            subsets.add(orgigins[startIndex]);
            allCombin2(orgigins, startIndex + 1, subsets);
            //回溯到父节点时，先将该节点清除
            subsets.removeLast();
        }
    }
}
