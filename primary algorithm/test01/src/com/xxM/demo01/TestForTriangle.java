package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-24 20:26:14 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForTriangle {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 8-i; i1++) {
                System.out.print(" ");
            }
            for (int i1 = 0; i1 < i; i1++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
}
