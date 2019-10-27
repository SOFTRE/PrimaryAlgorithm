package com.xxM.demo01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 转换古罗马数字
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-17 22:41:00 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForRomanNumerals {
    public static void main(String[] args) {
        String str="IXC";
        System.out.println(romanNumerals(str));
    }

    /**
     * 先检索两位数字，再检索一位数字
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * @param s s
     * @return int
     */
    public static int romanNumerals(String s){
        Map<String, Integer> map = new HashMap<>(15);
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int data=0;
        for (int i = 0; i < s.length();) {
            if (i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                data+=map.get(s.substring(i,i+2));
                i+=2;
            }else {
                data+=map.get(s.substring(i,i+1));
                i+=1;
            }
        }
        return data;
    }
}
