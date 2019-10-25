package com.xxM.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Program: IntelliJ IDEA jichu
 * @Description:
 * @Author: Mr Liu
 * @Creed: Talk is cheap,show me the code
 * @CreateDate: 2019-10-10 09:02:30 周四
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version: ULTIMATE
 */
interface ISubject {
    void eat(String msg, Integer count);
}

class RealSubject implements ISubject {
    @Override
    public void eat(String msg, Integer count) {
        System.out.println("我要吃：" + count + "分量的" + msg);
    }
}

class ProxySubject implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public void start() {
        System.out.println("开始");
    }

    public void end() {
        System.out.println("结束");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        start();
        Object invoke = method.invoke(this.target, args);
        end();
        return invoke;
    }
}

/**
 * 没有接口情况下的动态代理实现类之二
 * @Author: Mr Liu
 */
public class TestForDynamicProxyTwo {
    public static void main(String[] args) {
        ISubject iSubject = (ISubject) new ProxySubject().bind(new RealSubject());
        iSubject.eat("鱼香肉丝", 2);
    }
}
