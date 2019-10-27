package com.xxM.demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Program: IntelliJ IDEA jichu
 * @Description: 高可用的静态代理实现类(结合反射与泛型实现)
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-10 09:19:00 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
interface ISubject1 {
    void save();
}

class RealSubject1 implements ISubject1 {

    @Override
    public void save() {
        System.out.println("英勇的救了人");
    }
}

class ProxySubject1 implements ISubject1 {
    private ISubject1 iSubject1;

    public ProxySubject1(ISubject1 iSubject1) {
        this.iSubject1 = iSubject1;
    }

    public void broke() {
        System.out.println("破门而入");
    }

    public void getAward() {
        System.out.println("获得奖励");
    }

    @Override
    public void save() {
        broke();
        this.iSubject1.save();
        getAward();
    }
}

class Factory {
    private Factory() {
    }

    public static <T> T getInstance(String realClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        T object = (T) Class.forName(realClassName).newInstance();
        return object;
    }

    public static <T> T getInstance(String proxyClassName, String realClassName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Object obj = getInstance(realClassName);
        Constructor<?> constructor = Class.forName(proxyClassName).getConstructor(obj.getClass().getInterfaces()[0]);
        Object object = constructor.newInstance(obj);
        return (T) object;
    }
}

/**
 * @Author: Mr Liu
 */
public class TestForStaticProxy {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ISubject1 iSubject1 = Factory.getInstance("com.xxM.demo.ProxySubject1", "com.xxM.demo.RealSubject1");
        iSubject1.save();
    }
}
