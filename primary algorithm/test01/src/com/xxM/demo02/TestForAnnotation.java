package com.xxM.demo01;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/**
 * @Author Mr Liu
 */
@interface MyAnnotation{
    String name();
    int age();
}

@SuppressWarnings("serial")
@MyAnnotation(name = "张飞",age = 2)
class Member implements Serializable{}

/**
 * @Author Mr Liu
 */
public class TestForAnnotation {
    public static void main(String[] args) {
       MyAnnotation myAnnotation=Member.class.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println("姓名:"+myAnnotation.name());
        System.out.println("年龄:"+myAnnotation.age());
    }
}
