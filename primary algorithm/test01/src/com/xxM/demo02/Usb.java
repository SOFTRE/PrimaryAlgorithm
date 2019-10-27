package com.xxM.demo02;
interface Usb0{
    /**
     * 安装驱动
     */
    void setUp();

    /**
     * 进行工作
     */
    void work();
}

class Computer{
    public void open(){
        System.out.println("打开电脑！");
    }
    public void plugin(Usb0 usb0){
        usb0.setUp();
        if (usb0 instanceof Mouse){
            Mouse mouse=(Mouse)usb0;
            mouse.chick();
        }
        if (usb0 instanceof KeyBoard){
            KeyBoard keyboard=(KeyBoard)usb0;
            keyboard.fit();
        }
        usb0.work();
    }
    public void close(){
        System.out.println("关闭电脑！");
    }
}

class Mouse implements Usb0{
    @Override
    public void setUp() {
        System.out.println("连接鼠标！");
    }
    public void chick(){
        System.out.println("点击鼠标，完成工作");
    }
    @Override
    public void work() {
        System.out.println("断开鼠标");
    }
}

class KeyBoard implements Usb0{
    @Override
    public void setUp() {
        System.out.println("连接键盘");
    }
    public void fit(){
        System.out.println("进行键盘录入，完成工作");
    }
    @Override
    public void work() {
        System.out.println("关闭键盘");
    }
}

/**
 * @Author Mr Liu
 */
public class Usb {
    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.open();
        computer.plugin(new Mouse());
        computer.plugin(new KeyBoard());
        computer.close();
    }
}
