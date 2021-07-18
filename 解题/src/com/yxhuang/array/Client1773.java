package com.yxhuang.array;

import java.util.List;

public class Client1773 {

    public static void main(String[] args) {


    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
       int result = 0;
        if("type".equals(ruleKey)){
            for (List<String> list: items){
                String value = list.get(0);
                if (value.equals(ruleValue)){
                    result++;
                }
            }
        } else if ("color".equals(ruleKey)){
            for (List<String> list: items){
                String value = list.get(1);
                if (value.equals(ruleValue)){
                    result++;
                }
            }
        } else {
            for (List<String> list: items){
                String value = list.get(2);
                if (value.equals(ruleValue)){
                    result++;
                }
            }
        }
        return result;
    }

}
