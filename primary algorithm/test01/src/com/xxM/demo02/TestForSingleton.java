package com.xxM.demo02;

class Singleton{
    private static Singleton singleton;
    private Singleton(){
        System.out.println("[]"+Thread.currentThread().getName());
    }
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
/**
 * @Author Mr Liu
 */
public class TestForSingleton {
    public static void main(String[] args) {
        new Thread(()->Singleton.getInstance(),"线程A").start();
        new Thread(()->Singleton.getInstance(),"线程B").start();
        new Thread(()->Singleton.getInstance(),"线程C").start();
    }
}
