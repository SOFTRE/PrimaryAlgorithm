package com.xxM.demo01;

import java.util.Arrays;

/**
 * @Program: IntelliJ IDEA PrimaryAlgorithm
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-12-08 19:14:08 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForInsertSort {
    public static void main(String[] args) {
        int[] array={12,73,45,69,35};
        int i,j,temp;
        for(i=1;i<array.length;i++) {
            /*
             * 第一个for循环
             * 把数组分成两部分，右边为未排序，左边为已排序
             * 记录排序与未排序分割点temp（temp为下一个排序对象）
             */
            temp=array[i];
            for(j=i-1;j>=0;j--) {
                /*
                 * 第二个for循环
                 * 将排序对象temp与已排序数组比较
                 * 当temp比最近左边的数大时（按从小到大循序排列时）
                 * 直接结束本次循环，进行下一个数排序
                 * 否则比左边这个数小时将这个数后移，腾出这个数的位置
                 */
                if (temp > array[j]) {
                    break;
                }else{
                    array[j+1] = array[j];
                }
            }
            array[j+1]=temp;
        }
        System.out.println(Arrays.toString(array));
    }
}