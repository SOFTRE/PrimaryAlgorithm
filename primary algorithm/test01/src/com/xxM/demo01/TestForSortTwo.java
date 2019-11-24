package com.xxM.demo01;

import java.util.Arrays;

/**
 * @Author Mr Liu
 */
public class TestForSortTwo {
    public static void main(String[] args) {
        int [] data=new int[]{10,20,30,40,50};
        int number=12;
        int [] y=new int[data.length+1];
        for (int i = 0; i < data.length; i++) {
            y[i]=data[i];
        }
        y[data.length]=number;
        for (int i = 0; i < y.length-1; i++) {
            for (int i1 = 0; i1 < y.length - i-1; i1++) {
                if (y[i1]>y[i1+1]){
                    int temp=y[i1];
                    y[i1]=y[i1+1];
                    y[i1+1]=temp;
                }
            }
        }
//        for (int j = y.length-1; j > 0; j--) {
//            if (y[j-1]>y[j]){
//                int temp=y[j];
//                y[j]=y[j-1];
//                y[j-1]=temp;
//            }
//        }
        System.out.println(Arrays.toString(y));
    }
}
