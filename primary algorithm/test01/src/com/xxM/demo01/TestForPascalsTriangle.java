package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 杨辉三角
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-10 12:44:20 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */

import java.util.Scanner;

public class TestForPascalsTriangle {
    public static void main(String[] args) {
        printYFTriangle();
    }

    /**
     * 1 要理解下面的实现，首先要明白int数组中元素默认值为 0
     * 2 然后每一次迭代打印新的一行的元素的时候：
     *     新的特定位置的元素 = 该位置原来的元素 + 该位置的前一个位置的值
     */
    public static void printYFTriangle() {
        System.out.println("how many lines you want:");
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        int[] a = new int[lines + 1];
        int previous = 1;
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                //第三个变量的作用，要实现循环变更，那么让他变更得那个数也得变更。
                int current = a[j];
                a[j] = previous + current;
                previous = current;
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
}