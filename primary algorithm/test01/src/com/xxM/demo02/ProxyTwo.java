package com.xxM.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ISubject2{
    /**
     * 救人操作（姓名，年龄）
     * @param name
     * @param age
     */
    void save(String name, int age);
}

class RealSubject2 implements ISubject2{
    @Override
    public void save(String name,int age) {
        System.out.println("英勇的救出了"+age+"岁的"+name);
    }
}

class ProxySubject2 implements InvocationHandler{
    private Object target;
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public void open(){
        System.out.println("破门而入");
    }
    public void get(){
        System.out.println("获得荣誉奖励");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.open();
        Object obj=method.invoke(this.target,args);
        this.get();
        return obj;
    }
}

/**
 * @Author Mr Liu
 */
public class ProxyTwo {
    public static void main(String[] args) {
        ISubject2 iSubject=(ISubject2) new ProxySubject2().bind(new RealSubject2());
        iSubject.save("廖毅珂",24);
    }
}
