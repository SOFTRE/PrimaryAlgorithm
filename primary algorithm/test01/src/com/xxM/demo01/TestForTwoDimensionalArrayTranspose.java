package com.xxM.demo01;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-24 20:45:35 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForTwoDimensionalArrayTranspose {
    public static void main(String[] args) {
        int data[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        reverse(data);
        printArray(data);
    }
    public static void reverse(int data[][]){
        for (int i = 0; i < data.length; i++) {
            for (int i1 = i; i1 < data[i].length; i1++) {
                int temp=data[i][i1];
                data[i][i1]=data[i1][i];
                data[i1][i]=temp;
            }
        }
    }
    public static void printArray(int data[][]){
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data.length; i1++) {
                System.out.print(data[i][i1]+" ");
            }
            System.out.println();
        }
    }
}
