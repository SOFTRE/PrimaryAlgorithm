package com.xxM.demo01;
class Pen{
    public synchronized void get(Note note){
        System.out.println("我想得到本");
        note.result();
    }
    public synchronized void result(){
        System.out.println("我用它来涂鸦");
    }
}

class Note{
    public synchronized void get(Pen pen){
        System.out.println("我想得到笔");
        pen.result();
    }
    public synchronized void result(){
        System.out.println("我用它上厕所");
    }
}

/**
 * @Author Mr Liu
 */
public class TestForDeadLock implements Runnable{
    private static Note note=new Note();
    private static Pen pen=new Pen();
    public static void main(String[] args) {
        new TestForDeadLock();
    }
    public TestForDeadLock(){
        new Thread(this).start();
        pen.get(note);
    }
    @Override
    public void run(){
        note.get(pen);
    }
}
