package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-24 20:44:02 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForReverseTwo {
    public static void main(String[] args) {
        int data[]=new int[]{12,14,43214,324,324,43242,423};
        int result[]=reverse(data);
        printArray(result);
    }
    //定义新数组并将原数组反向取出
    public static int [] reverse(int data[]){
        int temp[]=new int[data.length];
        int index=0;
        for (int i = data.length-1; i >= 0; i--) {
            temp[index++]=data[i];
        }
        return temp;
    }
    public static void printArray(int data[]){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+",");
        }
    }
}
