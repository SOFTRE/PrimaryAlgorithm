package com.xxM.demo03;

/**
 * @Author Mr Liu
 */
public class TestForBinarySearchTwo {
    public static void main(String[] args) {
        int [] data=new int[]{21,23,33,43,56,76,87,99,678,889};
        System.out.println(binarySearch(data,0,data.length-1,33));
    }
    public static int binarySearch(int [] data,int head,int tail,int key){
        if (head<=tail){
            int mid=(head+tail)/2;
                if (data[mid]==key){
                    return mid;
                }
                if (data[mid]>key){
                    return binarySearch(data,head,mid-1,key);
                }
                if (data[mid]<key){
                    return binarySearch(data,mid+1,tail,key);
                }
                head++;
                tail--;
            }
        return -1;
    }
}
