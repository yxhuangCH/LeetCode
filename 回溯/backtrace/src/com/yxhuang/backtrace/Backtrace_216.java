package com.yxhuang.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Backtrace_216 {

    private static List<List<Integer>> mResult = new ArrayList<>();
    private static int mK = 0;
    private static int mSum = 0;

    public static void main(String[] args) {
        combinationSum3(3, 9);
        for (List<Integer> list : mResult){
            for (int i: list){
                System.out.print(i + "");
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0){
            return Collections.emptyList();
        }
//        mK = k;
//        mSum = n;
//        combin(1,  new LinkedList<>());
//        return mResult;

        mK = k;
        mSum = n;
        combin2(1, 0, new LinkedList<>());
        return mResult;
    }

    private static void combin(int startIndex, LinkedList<Integer> combinList){
        if (mK == combinList.size()){
            int sum = 0;
            for (Integer integer : combinList){
                sum = sum + integer;
            }
            if (sum == mSum){
                mResult.add(new ArrayList<>(combinList));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++){
            combinList.add(i);
            combin(i + 1, combinList);
            combinList.removeLast();
        }
    }

    private static void combin2(int startIndex, int sum, LinkedList<Integer> combinList){
        if (mK == combinList.size() && sum == mSum){
            mResult.add(new ArrayList<>(combinList));
            return;
        }

        for (int i = startIndex; i <= 9; i++){
            sum +=i;
            combinList.add(i);
            combin2(i + 1, sum, combinList);
            sum -=i;
            combinList.removeLast();
        }
    }
}
