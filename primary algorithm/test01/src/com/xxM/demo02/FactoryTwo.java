package com.xxM.demo02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

interface IFruit2{
    /**
     * 吃水果
     */
    void eat();
}

class Apple2 implements IFruit2{
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

/**
 * @Author Mr Liu
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    Class<?>target();
}

@MyAnnotation2(target = Apple2.class)
class Factory2{
    public static <T>T getInstance() throws IllegalAccessException, InstantiationException {
        MyAnnotation2 myAnnotation2=Factory2.class.getAnnotation(MyAnnotation2.class);
        return (T)myAnnotation2.target().newInstance();
    }
}

/**
 * @Author Mr Liu
 */
public class FactoryTwo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IFruit2 fruit2= Factory2.getInstance();
        fruit2.eat();
    }
}
