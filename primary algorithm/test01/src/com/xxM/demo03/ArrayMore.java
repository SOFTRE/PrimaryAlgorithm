package com.xxM.demo01;

import java.util.Arrays;

class Array{
    private int []data;
    private int len;
    public Array(int len){
        if (len>0){
            this.data=new int[len];
        }else {
            this.data=new int[1];
        }
    }
    private int foot;
    public void inc(int len){
        int [] data=new int[this.data.length+len];
        System.arraycopy(this.data,0,data,0,this.data.length);
        this.data=data;
    }
    public boolean add(int data){
        if (this.foot>this.data.length){
            return false;
        }
        this.data[foot++]=data;
            return true;
    }
    public int[] getData(){
        return this.data;
    }
}

class ArraySort extends Array{
    public ArraySort(int len){
        super(len);
    }
    @Override
    public int[] getData() {
        Arrays.sort(super.getData());
        return super.getData();
    }
}

class ArrayReverse extends Array{
    public ArrayReverse(int len){
        super(len);
    }
    @Override
    public int [] getData(){
        int head=0;
        int tail=super.getData().length-1;
        for (int i = 0; i < (super.getData().length-1)/2; i++) {
            int temp=super.getData()[head];
            super.getData()[head]=super.getData()[tail];
            super.getData()[tail]=temp;
            head++;
            tail--;
        }
        return super.getData();
    }
}

/**
 * @Author Mr Liu
 */
public class ArrayMore {
    public static void main(String[] args) {
        ArrayReverse array=new ArrayReverse(3);
        System.out.println(array.add(33));
        System.out.println(array.add(2));
        System.out.println(array.add(3));
        array.inc(2);
        System.out.println(array.add(218882));
        System.out.println(array.add(218880));
    }
}
