package Lesson_3_homework;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("localhost", 8189);
            Scanner in = new Scanner(socket.getInputStream());

            Scanner console = new Scanner(System.in);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Thread t1 =  new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = in.nextLine();
                        System.out.println(str);
                    }
                }
            });

            t1.start();

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Создаем студента и отправляем на сервер...");

                        Student stClient = new Student(1,"Nikolay");
                        try {
                            oos.writeObject(stClient);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String str = console.nextLine();
                    }
                }
            });

            t2.setDaemon(true);
            t2.start();


            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
