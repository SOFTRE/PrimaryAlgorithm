package com.xxM.demo02;
class Message{
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

class MessageConsumer{
    public void print(){
        System.out.println(Thread.currentThread().getName()+"="+MyUtil.get().getNote());
    }
}

class MyUtil{
private static  ThreadLocal<Message> threadLocal=new ThreadLocal<>();
    public static void set(Message message) {
        threadLocal.set(message);
    }
    public static Message get(){
        return threadLocal.get();
    }
}

/**
 * @Author Mr Liu
 */
public class TestForThreadLocal {
    public static void main(String[] args) {
        new Thread(()->{
            Message message=new Message();
            message.setNote("上天");
            MyUtil.set(message);
            new MessageConsumer().print();
        }).start();
        new Thread(()->{
            Message message=new Message();
            message.setNote("入地");
            MyUtil.set(message);
            new MessageConsumer().print();
        }).start();
    }
}
