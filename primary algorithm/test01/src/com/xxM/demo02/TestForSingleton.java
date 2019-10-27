package com.xxM.demo02;
class Singleton{
    private static Singleton instance;
    private Singleton(){
        System.out.println("[]"+Thread.currentThread().getName());
    }
    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
//    public void print(){
//        System.out.println("普通方法！");
//    }
}

/**
 * @Author Mr Liu
 */
public class TestForSingleton {
    public static void main(String[] args) {
        new Thread(()->Singleton.getInstance(),"线程A").start();
        new Thread(()->Singleton.getInstance(),"线程B").start();
        new Thread(()->Singleton.getInstance(),"线程C").start();
        new Thread(()->Singleton.getInstance(),"线程D").start();
        new Thread(()->Singleton.getInstance(),"线程E").start();

    }
}
