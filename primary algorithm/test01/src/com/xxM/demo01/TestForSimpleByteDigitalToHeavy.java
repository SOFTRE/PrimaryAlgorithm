package com.xxM.demo;

import java.util.Arrays;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 字节数组去重，简单解法
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-15 08:50:47 周二
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForSimpleByteDigitalToHeavy {
    public static void main(String[] args) {
        char[] charArray = {'a', 'l', 'f', 'm', 'f', 'o', 'b', 'b', 's', 'n'};
        simpleByteDigitalToHeavy(charArray);
    }

    /**
     * 利用26英文字母的组成将26位字母出现的位置的索引++；然后取出（0-26）不为0的(char)i+97
     * 用0-26数字作为i
     *
     * @param array
     */
    public static void simpleByteDigitalToHeavy(char[] array) {
        int[] data = new int[26];
        int foot = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            data[(array[i] - 97)]++;
        }
        for (int i = 0; i < array.length; i++) {
            if (data[array[i] - 97] != 0) {
                count++;
            }
        }
        char[] temp = new char[count];
        for (int i = 0; i < array.length; i++) {
            if (data[array[i] - 97] != 0) {
                temp[foot++] = (char) (i + 97);
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}
