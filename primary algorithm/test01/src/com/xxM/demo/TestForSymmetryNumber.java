package com.xxM.demo;

/**
 * @Program: IntelliJ IDEA test
 * @Description: 回文数和整数反转
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-13 11:08:47 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
public class TestForSymmetryNumber {
    public static void main(String[] args) {
        int num = 12322;
        System.out.println(isSymmetryNumber(num));
        System.out.println(numberReverse(num));
    }

    /**
     * 判断是否是回文数
     * @param num num>0
     * @return boolean
     */
    public static boolean isSymmetryNumber(int num) {
        int newNum=0;
        int oldNum=num;
        int temp;
        while (num != 0) {
            temp = num % 10;
            newNum = newNum * 10 + temp;
            num /= 10;
        }
        if (newNum != oldNum||oldNum<0) {
            return false;
        }
        return true;
    }

    /**
     * 整数反转
     * @param num num>0
     * @return int 新的数值newNum
     */
    public static int numberReverse(int num){
        int newNum=0;
        if (num<0){
            return -1;
        }
        while (num!=0){
            if (num>Integer.MIN_VALUE&&num<Integer.MAX_VALUE){
                int temp=num%10;
                newNum=newNum*10+temp;
                num/=10;
            }else {
                return -1;
            }
        }
        return newNum;
    }
}
