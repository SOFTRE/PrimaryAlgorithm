package com.xxM.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface User {
    void add(String msg);

    void delete(String msg);
}

class UserBody implements User {
    @Override
    public void add(String msg) {
        System.out.println(msg);
    }

    @Override
    public void delete(String msg) {
        System.out.println(msg);
    }
}

/**
 * 没有接口情况下的动态代理实现类之一
 * @Author: Mr Liu
 */
public class TestForDynamicProxyOne {
    public static void main(String[] args) {
        User user = new UserBody();
        User user1 = (User) Proxy.newProxyInstance(
                user.getClass().getClassLoader(),
                user.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始");
                        Object invoke = method.invoke(user, args);
                        System.out.println("结束");
                        return invoke;
                    }
                }
        );
        user1.delete("浪浪浪");
        user1.add("沙沙沙");
    }
}
