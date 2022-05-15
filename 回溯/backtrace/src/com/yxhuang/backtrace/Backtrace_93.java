package com.yxhuang.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Backtrace_93 {

    private static List<String> mResult = new ArrayList<>();


    public static void main(String[] args) {
        String s = "25525511135";
        restoreIpAddresses(s);
        for (String idStr : mResult){
            System.out.println(idStr);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12 ){
            return Collections.emptyList();
        }
        mResult.clear();
        backStrace(s, 0, 0);
        return mResult;
    }

    public static void backStrace(String s, int startIndex, int pointNum) {
        if (pointNum == 3) { // 逗号数量为 3 时，分隔结束
            if (isValidId(s, startIndex, s.length() - 1)) {
                mResult.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValidId(s, startIndex, i)) { // 判断[startIndex, i] 这个子串是否合法
                s = s.substring(0, i + 1) + "." + s.substring(i + 1); // 插入逗号
                pointNum++;
                backStrace(s, i + 2, pointNum); // 因为已经插入逗号了，所以要 + 2
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2); // 回溯，删除逗号
            } else {
                break;
            }
        }
    }


    private static boolean isValidId(String sr, int start, int end) {
        if (start > end) {
            return false;
        }
        if (sr.charAt(start) == '0' && start != end) { // 开为 0 的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            char idChar = sr.charAt(i);
            if (idChar > '9' || idChar < '0') {
                return false;
            }
            num = num * 10 + (idChar - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
