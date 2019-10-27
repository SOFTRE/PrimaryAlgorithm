package com.xxM.demo01;
abstract class Action{
    public static final int EAT=0;
    public static final int SLEEP=1;
    public static final int WORK=2;
    public void command(int cmd){
        switch (cmd){
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
            case EAT+SLEEP+WORK:
                this.eat();
                this.sleep();
                this.work();
        }
    }
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
}

class Human extends Action{

    @Override
    public void eat() {
        System.out.println("人要吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("人要睡觉");
    }

    @Override
    public void work() {
        System.out.println("人要工作");
    }
}

class Pig extends Action{
    @Override
    public void eat() {
        System.out.println("猪在槽子里吃");
    }

    @Override
    public void sleep() {
        System.out.println("猪在圈子里睡");
    }

    @Override
    public void work() {
        System.out.println("猪不用工作");
    }
}

class Robot extends Action{

    @Override
    public void eat() {
        System.out.println("机器人充能续航");
    }

    @Override
    public void sleep() {
        System.out.println("机器人24小时不休息");
    }

    @Override
    public void work() {
        System.out.println("机器人工作24小时不停息");
    }
}

/**
 * @Author Mr Liu
 */
public class AbstractClass {
    public static void main(String[] args) {
        method(new Human());
        method(new Pig());
        method(new Robot());
    }
    public static void method(Action action){
        action.command(Action.EAT+Action.SLEEP+Action.WORK);
    }
}
