package com.xxM.demo;

import java.util.Arrays;

/**
 * @Program: IntelliJ IDEA test
 * @Description: for循环数字去重
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-15 08:32:45 周二
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForDigitalToHeavy {
    public static void main(String[] args) {
        //数字去重，两种解法
        int[] data = new int[]{9, 10, 6, 6, 1, 9, 3, 5, 6, 4};
        digitalToHeavy01(data);
        digitalToHeavy02(data);
    }

    /**
     * 01-定义新数组，将不重复的数字取出到新数组里面
     *
     * @param data data
     */
    public static void digitalToHeavy01(int[] data) {
        int[] temp = new int[data.length];
        int foot = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < temp.length; i1++) {
                if (data[i] == temp[i1]) {
                    break;
                }
                if (i1 == temp.length - 1) {
                    temp[foot++] = data[i];
                    count++;
                }
            }
        }
        int cal = 0;
        int[] newDate = new int[count];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                newDate[cal++] = temp[i];
            }
        }
        System.out.println(Arrays.toString(newDate));
    }

    /**
     * 02-与自身作比较，将重复的数字变为0，取出不为0的数
     *
     * @param data
     */
    public static void digitalToHeavy02(int[] data) {
        int foot = 0;
        int count = 0;
        for (int i = 0; i < data.length - 1; i++) {
            for (int i1 = i + 1; i1 < data.length; i1++) {
                if (data[i] == 0) {
                    break;
                }
                if (data[i] == data[i1]) {
                    data[i1] = 0;
                    count++;
                }
            }
        }
        int[] temp = new int[data.length - count];
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                temp[foot++] = data[i];
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}
