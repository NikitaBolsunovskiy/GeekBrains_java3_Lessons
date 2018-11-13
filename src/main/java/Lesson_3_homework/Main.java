package Lesson_3_homework;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {

        //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        File f = new File("./lesson_3_homework_Task1_test.txt");
        try(FileInputStream in = new FileInputStream(f)){
            byte[] arr = new byte[50];
            int x;
            while ((x = in.read(arr))!=-1) {
                System.out.print(new String(arr,0,x, StandardCharsets.UTF_8));
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        //2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
        try {
            ArrayList<FileInputStream> arrayListFileIS = new ArrayList<>();
            arrayListFileIS.add(new FileInputStream(new File("./lesson_3_homework_Task2_test1.txt")));
            arrayListFileIS.add(new FileInputStream(new File("./lesson_3_homework_Task2_test2.txt")));
            arrayListFileIS.add(new FileInputStream(new File("./lesson_3_homework_Task2_test3.txt")));
            arrayListFileIS.add(new FileInputStream(new File("./lesson_3_homework_Task2_test4.txt")));
            arrayListFileIS.add(new FileInputStream(new File("./lesson_3_homework_Task2_test5.txt")));

            FileOutputStream fos = new FileOutputStream(new File("./lesson_3_homework_Task2_testOutput.txt"));

            SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(arrayListFileIS));
            int x;
            while ((x = sis.read())!=-1) {
                System.out.print((char)x);
                fos.write(x);
            }
            sis.close();
            fos.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        //3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.

        // На файле размером 31MB - 1217 миллисекунд.
        long t = System.currentTimeMillis();
        try {
            File fBig = new File("./lesson_3_homework_Task3_testBig.txt");
            BufferedReader bf = new BufferedReader(new FileReader(fBig));
            char[] page = new char[1800];
            int x;
            while ((x = bf.read(page))!=-1) {
                System.out.print(new String(page));
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Время выполнения: ");
        System.out.println(System.currentTimeMillis()-t);

        // Доп. ДЗ.


    }

}
