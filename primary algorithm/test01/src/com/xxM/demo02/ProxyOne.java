package com.xxM.demo02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface ISubject {
    void save();
}

class RealSubject implements ISubject {
    @Override
    public void save() {
        System.out.println("英勇的完成了救人动作");
    }
}

class ProxySubject implements ISubject {
    private ISubject iSubject;

    public ProxySubject(ISubject iSubject) {
        this.iSubject = iSubject;
    }

    public void open() {
        System.out.println("破门而入！");
    }

    public void get() {
        System.out.println("获得奖励！");
    }

    @Override
    public void save() {
        this.open();
        iSubject.save();
        this.get();
    }
}

class Factory1 {
    public static <T> T getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        T obj = (T) Class.forName(className).newInstance();
        return obj;
    }

    public static <T> T getInstance(String proxyClassName, String realClassName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        T t = getInstance(realClassName);
        Constructor<?> constructor = Class.forName(proxyClassName).getConstructor(t.getClass().getInterfaces()[0]);
        T obj = (T) constructor.newInstance(t);
        return obj;
    }
}

/**
 * @Author Mr Liu
 */
public class ProxyOne {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ISubject iSubject = Factory1.getInstance("com.itheima.demo01.ProxySubject",
                "com.itheima.demo01.RealSubject");
        iSubject.save();
    }
}
