package com.yxhuang.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Backtrace_17 {

    private static List<String> sResult = new ArrayList<>();


    public static void main(String[] args) {
        letterCombinations("23");
        for (String sr: sResult){
            System.out.println("result: " + sr);
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return Collections.emptyList();
        }
        sResult.clear();
        // 创建映射表
        String[] numStrOrigin = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        char[] chars = digits.toCharArray();
        // 拿到对应的字符串
        List<String> numStrList = new ArrayList<>(chars.length);
        for (char ch: chars){
            int index = Character.getNumericValue(ch);
            String value = numStrOrigin[index];
            System.out.println("index: " + index + " value:" + value);
            numStrList.add(value);
        }
        // 进行回溯
        backtrace(numStrList, digits.length(), 0,new  StringBuilder());
        return sResult;
    }

    /**
     * 回溯
     * @param numbStr        字符串列表
     * @param digitsLength   数组的长度，作为最后层级的判断
     * @param numIndex       深度遍历的层级
     * @param levelResult    遍历的结果
     */
    private static void backtrace(List<String> numbStr,int digitsLength,  int numIndex, StringBuilder levelResult ){
        if (levelResult.length() == digitsLength){
            sResult.add(new String(levelResult));
            return;
        }
        // 获取到当前层级的字符串
        String numMapStr = numbStr.get(numIndex);
        // 将当前层级的字符串转换为字符数组
        char[] chars = numMapStr.toCharArray();
        // 横向遍历当前层级的字符串数组
        for (char aChar : chars) {
            levelResult.append(aChar);
            backtrace(numbStr, digitsLength, numIndex + 1, levelResult);
            // 回溯，移除
            levelResult.deleteCharAt(levelResult.length() - 1);
        }
    }
}
