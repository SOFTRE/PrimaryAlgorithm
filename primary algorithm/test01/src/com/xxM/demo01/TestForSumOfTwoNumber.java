package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 求数组中两数之和是9的数字
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-17 22:23:27 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForSumOfTwoNumber {
    public static void main(String[] args) {
        int[] sum = {2, 7, 11, 15};
        int target = 9;
        sumOfTwoNumber(sum, target);
    }

    /**
     * 传入数字和目标数字
     *
     * @param sum    sum
     * @param target target
     */

    public static void sumOfTwoNumber(int[] sum, int target) {
        for (int i = 0; i < sum.length; i++) {
            for (int i1 = i; i1 < sum.length; i1++) {
                if (sum[i] + sum[i1] == target && i != i1) {
                    System.out.println("第" + (i + 1) + "位和" + "第" + (i1 + 1) + "位数字");
                }
            }
        }
    }
}
