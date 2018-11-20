package Lesson_5;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class RemindTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("Times up!");
    }
}

public class Main5 {

    Timer timer;

    void testSchedule() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 52);
        calendar.set(Calendar.SECOND,0);
        Date time = calendar.getTime();
        timer = new Timer();
        timer.schedule(new RemindTask(),time);
    }

    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    ai.getAndIncrement();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    ai.getAndDecrement();
                }
            }
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ai.get());


//        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.readLock().lock();
//                r1.writeLock().lock();
//                System.out.println(1);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(2);
//                r1.writeLock().unlock();
//                r1.readLock().unlock();
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.lock();    // if r1.tryLock(5,TimeUnit.SECONDS)
//                System.out.println(3);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(4);
//                r1.unlock();
//            }
//        }).start();


//        ReentrantLock r1 = new ReentrantLock();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.lock();
//                System.out.println(1);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(2);
//                r1.unlock();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.lock();    // if r1.tryLock(5,TimeUnit.SECONDS)
//                System.out.println(3);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(4);
//                r1.unlock();
//            }
//        }).start();

//        CyclicBarrier cb = new CyclicBarrier(4);
//        for (int i = 0; i < 20; i++) {
//            int w = i;
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(w + " - 1");
//
//                    try {
//                        Thread.sleep((int) (Math.random() * 3000));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(w + " - 2");
//
//                    try {
//                        cb.await();
//                    } catch (InterruptedException | BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//
//        System.out.println("END");


//        CountDownLatch cdl = new CountDownLatch(10);
//
//        for (int i = 0; i < 10; i++) {
//            int w = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(w + " - 1");
//
//                    try {
//                        Thread.sleep((int)Math.random()*3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(w + " - 2");
//
//                    cdl.countDown();
//                }
//            }).start();
//        }
//
//        try {
//            cdl.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("END");

//        Semaphore smp = new Semaphore(4); // ограничение кол-ва потоков...
//
//        ExecutorService serv = Executors.newFixedThreadPool(10);
//
//        for (int i = 0; i < 10; i++) {
//            serv.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        smp.acquire();
//                        System.out.println("1");
//                        Thread.sleep(1000);
//                        smp.release();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("2");
//                }
//            });
//        }
//
//        serv.shutdown();



//        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(10);      // не динамический размер...
//        abq.add("str1");
//        boolean flag = false;
//        try {
//            flag = abq.offer("str2", 20, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            abq.put("str3");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(flag);




//        ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<>(); //блокировка только на ячейку, в которую записывается... чтение не синхронизировано...
//
//        chm.put("key1","value1");
//
//        Map<String,String> hm = Collections.synchronizedMap(new HashMap<>()); // при любом действии блокирует всю коллекцию...
//        //Collections.synchronizedCollection();
//




//        Main5 main5 = new Main5();
//        main5.testSchedule();

//        Random random = new Random();
//
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//        //executorService.scheduleAtFixedRate(new Runnable() {
//        executorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println( new java.util.Date() + "start work!");
//                try {
//                    Thread.sleep(random.nextInt(500));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println( new java.util.Date() + "end work!");
//            }
//        }, 0,1000L, TimeUnit.MILLISECONDS);



//        ExecutorService pool = Executors.newFixedThreadPool(4, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//
//                Thread t = new Thread(r);
//                return t;
//            }
//        });
//        Future<String> out = pool.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "Java";
//            }
//        });
//        try {
//            System.out.println(out.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        pool.shutdown();


//        // Создаем фиксированное количество потоков...
//        ExecutorService pool = Executors.newFixedThreadPool(4, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                System.out.println("new Thread");
//                Thread t = new Thread(r);
//                return t;
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("2");
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("3");
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("4");
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("5");
//            }
//        });
//
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("6");
//            }
//        });
//
//        try {
//            pool.awaitTermination(1000, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        pool.shutdown();




    }
}
