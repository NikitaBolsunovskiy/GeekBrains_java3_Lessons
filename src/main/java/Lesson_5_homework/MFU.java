package Lesson_5_homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MFU {

    final private Object printLock = new Object();
    final private Object scanLock = new Object();

    public void print(String doc, int n) {
        synchronized (printLock) {
            System.out.println("Печатаем документ: " + doc);
            try {
                Thread.sleep(n*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("Начало печати");
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("Конец печати: " + doc);
        }

    }

    public void scan(String doc, int n) {
        synchronized (scanLock) {
            System.out.println("Сканируем документ: " + doc);
            try {
                Thread.sleep(n*200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("Начало сканирования");
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("Конец сканирования: " + doc);
        }
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();

        int numberOfPrintTasks = 10;
        int numberOfScanTasks = 10;

        CountDownLatch cdl = new CountDownLatch(numberOfScanTasks + numberOfPrintTasks);

        ExecutorService es = Executors.newFixedThreadPool(10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberOfPrintTasks; i++) {
                    int docSize = (int) (Math.random() * 10 + 1);
                    int finalI = i;
                    es.execute(new Runnable() {
                        @Override
                        public void run() {
                            cdl.countDown();
                            mfu.print("Doc " + finalI,docSize);
                        }
                    });
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < numberOfScanTasks; j++) {
                    int docSize = (int) (Math.random() * 10 + 1);
                    int finalJ = j;
                    es.execute(new Runnable() {
                        @Override
                        public void run() {
                            cdl.countDown();
                            mfu.scan("Doc " + finalJ,docSize);
                        }
                    });
                }
            }
        }).start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();

    }

}