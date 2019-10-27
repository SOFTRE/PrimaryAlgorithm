package com.xxM.demo;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 计算1000以内的完数
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-22 22:55:45 周二
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForNumber1000 {
    public static void main(String[] args) {
        /**
         * 完数:能被比他小的数整除的商之和与其本身相等的数即完数
         */
        int sum;
        int num=1000;
        for (int i = 1; i <= num; i++) {
            sum=0;
            for (int i1 = 1; i1 < i; i1++) {
                if (i%i1==0){
                    sum=sum+i1;
                }
            }
            if (sum==i){
                System.out.println("完数:"+i);
            }
        }
    }
}
