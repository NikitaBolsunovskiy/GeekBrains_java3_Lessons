package Lesson_7;

import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class Main {

    //Классы инициализируются постепенно по мере обращения к ним кода...
    //Reflection исследует классы, методы, переменные, модификаторах. До создания экземпляра класса.

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, MalformedURLException, ClassNotFoundException, InstantiationException {

//        String str = "java";
//        Class stringClass = str.getClass();
//        System.out.println(stringClass);

//        Class c = Cat.class;
//        //Field[] fields = c.getFields();
//        Field[] fields = c.getDeclaredFields();
//
//        for (Field f: fields
//             ) {
//            System.out.println(f);
//        }

//        Cat cat = new Cat("barsik","white",2);
//        Class c = Cat.class;
//        cat.info();
//
//        Field f = c.getDeclaredField("age");
//        f.setAccessible(true);  //Обход модификатора private...
//
//        f.set(cat,10);
//        cat.info();
//
//        Method m = c.getMethod("info");
//        m.invoke(cat);
//
//        int mods = f.getModifiers();
//        System.out.println(mods);

//        Class ch = URLClassLoader.newInstance(new URL[]{new File("C:\\0123").toURL()}).loadClass("Human");
//
//        Constructor constructor = ch.getConstructor(String.class);
//
//        Object human = constructor.newInstance("Bob");
//        Method m = ch.getDeclaredMethod("info");
//        m.invoke(human);

        Class<?> cls = ArrayList.class;
        Class<?>[] ifs = cls.getInterfaces();

        for (Class<?> ifc: ifs
             ) {
            System.out.println(ifc.getName());
        }





    }

}
