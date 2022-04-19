package com.yxhuang.backtrace;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 */
public class Backtrace_131 {

    private static List<List<String>> sResult = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aab";
        partition(s);
        for (List<String> item : sResult) {
            for (String i : item) {
                System.out.println(i);
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0){
            return Collections.emptyList();
        }
        sResult.clear();
//        List<String> list = new ArrayList<>(s.length());
//        int length = s.length();
//        for (int i = 0 ;i < length; i++){
//            list.add(String.valueOf(s.charAt(i)));
//        }
        backTrace(s, new LinkedList<>());
        return sResult;
    }

    private static void backTrace(String s, LinkedList<String> levelStrResult){
        if (s == null || s.length() == 0){
            sResult.add(new ArrayList<>(levelStrResult));
        }

        for (int i = 1; i <= s.length(); i++){
            String value = s.substring(0, i);
            if (isPalindrome(value)){ // 如果是回文
                System.out.println("i: " + i + " value：" + value);
                levelStrResult.add(value);
                backTrace(s.substring(i), levelStrResult);
                String removeValue = levelStrResult.removeLast();
                System.out.println("i: " + i + " removeValue：" + removeValue);
            }
        }
    }

    private static boolean isPalindrome(String s){
        int length = s.length();
        if (length == 0){
            return false;
        }
        int i = 0;
        int j = length - 1;
        for (;i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
