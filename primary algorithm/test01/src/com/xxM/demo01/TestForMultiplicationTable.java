package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 简易乘法表
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-10 13:08:45 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForMultiplicationTable {
    public static void main(String[] args) {
        int a=9;
        for (int i = 1; i <= a; i++) {
            for (int i1 = 1; i1 <= i; i1++) {
                System.out.print(i+"*"+i1+"="+i*i1+"\t");
            }
            System.out.println();
        }
    }
}
