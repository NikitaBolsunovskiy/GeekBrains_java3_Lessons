package Lesson_1_homework;

import javax.naming.Name;
import java.util.ArrayList;

class ObjectArray <T>{

    private T[] Array;

    ObjectArray(T[] array) {
        Array = array;
    }

    ArrayList<T> getArList() {
        ArrayList<T> arList = new ArrayList<T>();
        for (int i = 0; i < Array.length; i++) {
            arList.add(Array[i]);
        }
        return arList;
    }

    T[] getArray() {
        return Array;
    }

    void setArray(T[] array) {
        Array = array;
    }

    void info(){
        for (int i = 0; i < Array.length; i++) {
            System.out.printf("" + Array[i]+"; ");
        }
        System.out.printf("\n");
        System.out.println("---------------------");
    }

    void changeElements(int n,int m){

        T x = Array[n];
        Array[n] = Array[m];
        Array[m] = x;

    }
}

abstract class Fruit {
    private int weight;

    Fruit(int weight) {
        this.weight = weight;
    }

    int getWeight() {
        return weight;
    }
}

class Orange extends Fruit{
    public Orange() {
        super(1);
    }
}

class Apple extends Fruit{
    public Apple() {
        super(2);
    }
}

class FruitBox<T extends Fruit>{
    private ArrayList<T> list;

    FruitBox() {
        this.list = new ArrayList<>();
    }
    void addFruit(T fruit){
        this.list.add(fruit);
    }

    int getWeight(){
        if (list.size() == 0) {
            return 0;
        }

        return list.size()* list.get(0).getWeight();
    }

    boolean compare(FruitBox<?> another){
        if (this.getWeight() == another.getWeight()){
            return true;
        }
        return false;
    }

    void move(FruitBox<T> another){
        for (int i = this.list.size(); i >0 ; i--) {
            another.addFruit(this.list.get(i-1));
            this.list.remove(this.list.get(i-1));
        }
    }

}

class Main {

    public static void main(String[] args) {

//        // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
//
//        Integer[] iArray = {1,2,3,4,5,6};
//        String[] sArray = {"123","231","321"};
//
//        ObjectArray<Integer> iOArray= new ObjectArray<Integer>(iArray);
//        ObjectArray<String> sOArray= new ObjectArray<String>(sArray);
//
//        System.out.println("Массив чисел исходный:");
//        iOArray.info();
//        iOArray.changeElements(1,3);
//        System.out.println("Массив чисел после перемены мест слагаемых:");
//        iOArray.info();
//
//        System.out.println("Массив строк исходный:");
//        sOArray.info();
//        sOArray.changeElements(0,2);
//        System.out.println("Массив строк после перемены мест слагаемых:");
//        sOArray.info();
//
//        // 2. Написать метод, который преобразует массив в ArrayList;
//
//        ArrayList arrayList = iOArray.getArList();
//        System.out.println(arrayList.toString());   // ArrayList будет заполнен так, как был заполнен ObjectArray, то есть элементы уже пересталены местами.
//
//        // 3. Большая задача:
//        //a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        //b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        //c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        //d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        //e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        //f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//        //g. Не забываем про метод добавления фрукта в коробку.

        FruitBox<Orange> orBox = new FruitBox<Orange>();
        FruitBox<Orange> orBox2 = new FruitBox<Orange>();
        FruitBox<Apple> apBox = new FruitBox<Apple>();

        for (int i = 0; i < 10; i++) {
            orBox.addFruit(new Orange());
        }
        for (int i = 0; i < 3; i++) {
            orBox2.addFruit(new Orange());
        }
        for (int i = 0; i < 5; i++) {
            apBox.addFruit(new Apple());
        }

        System.out.println("Вес коробки с апельсинами: " + orBox.getWeight());
        System.out.println("Вес коробки с апельсинами2: " + orBox2.getWeight());
        System.out.println("Вес коробки с яблоками: " + apBox.getWeight());

        System.out.println(orBox.compare(apBox));

        orBox.move(orBox2);

        System.out.println("Вес коробки с апельсинами после пересыпания: " + orBox.getWeight());
        System.out.println("Вес коробки с апельсинами2 после пересыпания: " + orBox2.getWeight());



    }


}