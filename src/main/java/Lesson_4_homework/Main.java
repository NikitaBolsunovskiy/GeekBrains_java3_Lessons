package Lesson_4_homework;

public class Main {

    static volatile char currentLetter; // volatile - переменная, обращений к котрой проходит черех главную память, не используется локальный кещ потока...

    public static void main(String[] args) {

        //1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
        task1();

    }

    static void task1(){

        MyObject obj = new MyObject("");

        Thread ta = new Thread(new Writer(obj,'A'));
        Thread tb = new Thread(new Writer(obj,'B'));
        Thread tc = new Thread(new Writer(obj,'C'));

        ta.start();
        tb.start();
        tc.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj){
            obj.notifyAll();
        }

        System.out.println(obj.getData());

    }

}

class MyObject {
    private String data;

    public MyObject(String data) {
        this.data = data;
    }

    public synchronized String getData() {
        return data;
    }

    public synchronized void setData(String data) {
        this.data = data;
    }
}

class Writer implements Runnable{

    private MyObject mobj;
    private char sym;

    public Writer(MyObject m, char sym){
        this.mobj = m;
        this.sym = sym;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (mobj) {
                mobj.setData(mobj.getData() + sym);
                System.out.println(mobj.getData());
                mobj.notify();
            }
            synchronized (mobj) {
                try {
                    mobj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}