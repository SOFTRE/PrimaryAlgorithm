package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-25 23:55:41 周五
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForLongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"asd", "aswe", "ads"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min_length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (min_length > strs[i].length()) {
                min_length = strs[i].length();
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < min_length; i++) {
            for (int j = i; j < strs.length-1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}
