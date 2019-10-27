package com.xxM.demo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 奇偶转置的不同方式
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-13 09:45:49 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForParityTranspose {
    public static void main(String[] args) {
        //奇偶转置
        int[] arr = {26, 67, 49, 38, 52, 66, 7, 71, 56, 87};
        parityReverse02(arr);
    }

    /**
     * 定义新数组接受不同属性的值
     *
     * @param array 被转换的数组
     */
    public static void parityReverse01(int[] array) {
        int[] newData = new int[array.length];
        int head = 0;
        int tail = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                newData[head++] = array[i];
            }
            if (array[i] % 2 != 0) {
                newData[tail--] = array[i];
            }
        }
        System.out.println(Arrays.toString(newData));
    }

    public static void parityReverse02(int[] array) {
        int head = 0;
        int tail = array.length - 1;
        while (head < tail) {
            while (array[head] % 2 == 0 && head < tail) {
                head++;
            }
            while (array[tail] % 2 != 0 && head < tail) {
                tail--;
            }
            int temp = array[head];
            array[head] = array[tail];
            array[tail] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
