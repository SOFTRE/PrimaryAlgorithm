package com.xxM.demo03;

/**
 * @Program: IntelliJ IDEA test
 * @Description: TODO
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-11-24 20:47:30 周日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: V1.0
 */
public class TestForBinarySearchThree {
    public static void main(String[] args) {
        int data[]={1,2,32,34,545,656,765,7656,86767};
        int search=32;
        System.out.println(index(data,search));
    }
    public static int index(int data[],int key){
        for (int i = 0; i < data.length; i++) {
            if (data[i]==key){
                return i;
            }
        }
        return -1;
    }
}
