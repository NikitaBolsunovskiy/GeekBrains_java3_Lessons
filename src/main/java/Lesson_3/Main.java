package Lesson_3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static BufferedWriter bw = null;
    static BufferedReader br = null;

    public static void main(String[] args) {

//        try{
//            bw = new BufferedWriter(new FileWriter("input.txt"));
//            for (int i = 0; i < 10; i++) {
//                bw.write("Java " + i);
//            }
//            bw.close();
//
//            br = new BufferedReader(new FileReader("input.txt"));
//            String str;
//            while ((str = br.readLine()) != null){
//                System.out.println(str);
//            }
//            br.close();
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }

//        File file = new File("1234/5");
//        file.mkdir();
//        file.mkdirs();

//        File file = new File("./");
//        String[] listoffiles = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                //return name.endsWith("txt");
//                return true;
//            }
//        });
//        for (String o : listoffiles) {
//            System.out.println(o);
//        }

//        file = new File("Test.txt");
//        if (file.exists()){
//            file.renameTo(new File("Test2.txt"));
//        }
//        long t = System.currentTimeMillis();
//        try (FileInputStream in = new FileInputStream("./Test2.txt")){
//            byte[] arr = new byte[512];
//            int x;
//            while ((x = in.read(arr))!=-1){
//                System.out.print(new String(arr,0,x, StandardCharsets.UTF_8));
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - t);

//        long t = System.currentTimeMillis();
//        try (InputStreamReader in = new InputStreamReader (new FileInputStream("./Test2.txt"))){
//            int x;
//            while ((x = in.read())!=-1){
//                System.out.print((char)x);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - t);

//        try{
//            String filename = "./Test2.txt";
//
//            BufferedReader br = null;
//            FileReader fr = null;
//
//            fr = new FileReader(filename);
//            br = new BufferedReader(fr);
//
//            String currentLine;
//            while ((currentLine = br.readLine()) != null){
//                System.out.println(currentLine);
//            }

//            PipedInputStream in = null;
//            PipedOutputStream out = null;
//
//            in = new PipedInputStream();
//            out = new PipedOutputStream();
//
//            out.connect(in);
//
//            for (int i = 0; i < 10; i++) {
//                out.write(i);
//            }
//
//            int x;
//
//            while((x = in.read())!= -1) {
//                System.out.print(x + " ");
//            }

//            ArrayList<InputStream> ali = new ArrayList<>();
//            ali.add(new FileInputStream("./Test2.txt"));
//            ali.add(new FileInputStream("./Test1.txt"));
//
//            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
//
//            int x;
//            while((x = in.read())!= -1) {
//                System.out.print((char)x);
//            }



//        } catch (IOException e){
//            e.printStackTrace();
//        }

//        try(RandomAccessFile raf = new RandomAccessFile("./Test2.txt","r")){
//            raf.seek(1);
//            System.out.println((char) raf.read());
//            System.out.println((char) raf.read());
//            System.out.println((char) raf.read());
//            System.out.println((char) raf.read());
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        try {
            Student st1 = new Student(1,"Nikita Bolsunovskij");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./stud.ser"));
            oos.writeObject(st1);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./stud.ser"));
            Student obj = (Student) ois.readObject();

            obj.info();
            System.out.println(st1 == obj);


        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }







    }

}

class Student implements Serializable{

    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info(){
        System.out.println(id + " " + name);
    }
}