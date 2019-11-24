package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 60的阶乘
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-24 20:20:55 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestFor60 {
    public static void main(String[] args) {
        System.out.println(sum(60));
    }
    public static double sum(int num){
        if (num==1){
            return num;
        }
        return num*sum(num-1);
    }
}
