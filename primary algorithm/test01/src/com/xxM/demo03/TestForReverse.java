package com.xxM.demo03;

/**
 * @Author Mr Liu
 */
public class TestForReverse {
    public static void main(String[] args) {
        int [][]data=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        reverse(data);
        print(data);
    }
    public static void reverse(int [][]data){
        for (int i = 0; i < data.length; i++) {
            for (int i1 = i; i1 < data.length; i1++) {
                int temp=data[i][i1];
                data[i][i1]=data[i1][i];
                data[i1][i]=temp;
            }
        }
    }
    public static void print(int [][]data){
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data.length; i1++) {
                System.out.print(data[i][i1]+" ");
            }
            System.out.println();
        }
    }
}
