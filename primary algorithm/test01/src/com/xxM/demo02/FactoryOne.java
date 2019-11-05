package com.xxM.demo02;
interface IFruits{
    /**
     * 吃操作
     */
    void eat();
}

interface IMessage{
    void print();
}

class Factory{
   public static <T>T getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        T obj=(T)Class.forName(className).newInstance();
        return obj;
   }
}

class Apple implements IFruits{

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Orange implements IFruits{
    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}

class Print implements IMessage{

    @Override
    public void print() {
        System.out.println("我们吃水果");
    }
}

/**
 * @Author Mr Liu
 */
public class FactoryOne {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IFruits iFruits=Factory.getInstance("com.xxM.demo01.Apple");
        iFruits.eat();
        IFruits iFruits1=Factory.getInstance("com.xxM.demo01.Orange");
        iFruits1.eat();
        IMessage iMessage=Factory.getInstance("com.xxM.demo01.Print");
        iMessage.print();

    }
}
