package com.xxM.demo01;

/**
 * @Author Mr Liu
 */
public class TestForBinarySearchOne {
    public static void main(String[] args) {
        int [] data=new int[]{21,23,33,43,56,76,87,99,678,889};
        System.out.println(binarySearch(data, 33));
    }
    public static int binarySearch(int [] data,int key){
        int left=0;
        int right=data.length-1;
        while (left<=right){
            int mid=(left+right)/2;
                if (data[mid]==key){
                    return mid;
                }
                if (data[mid]>key){
                     right=mid-1;
                }
                if (data[mid]<key){
                    left=mid+1;
                }
        }
        return -1;
    }
}
