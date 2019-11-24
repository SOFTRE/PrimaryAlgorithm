package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-24 20:41:17 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForBubble {
    public static void main(String[] args) {
        int data[]=new int[]{12,43,543,1231,432,4324,3242,543};
        Arraysort(data);
        printArray(data);
    }
    public static void Arraysort(int data[]){
        for (int i = 0; i < data.length-1; i++) {
            for (int i1 = 0; i1 < data.length-i-1; i1++) {
                if (data[i1]>data[i1+1]){
                    int temp=data[i1];
                    data[i1]=data[i1+1];
                    data[i1+1]=temp;
                }
            }
        }
    }
    public static void printArray(int data[]){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+",");
        }
    }
}
