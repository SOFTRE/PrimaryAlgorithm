package com.xxM.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-22 23:14:37 周二
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForRemoveTheNumberFromTheString {
    public static void main(String[] args) {
        //去掉包含数字的字符串，根据方法删除索引，和删除指定值
        String[] str = {"0af3s2sf", "s6ds1", "jjww", "lailai"};
        removeTheNumberFromTheString(str);
    }

    public static void removeTheNumberFromTheString(String[] str) {
        List<String> stringList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            stringList.add(str[i]);
            char[] chars = str[i].toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {
                if (chars[i1] > '0' && chars[i1] < '9') {
                    count++;
                }
            }
            if (count != 0) {
                stringList.remove(str[i]);
            }
            count = 0;
        }
        System.out.println(stringList);
    }
}
