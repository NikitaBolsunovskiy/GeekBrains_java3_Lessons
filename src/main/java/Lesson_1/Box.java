package Lesson_1;

class Box {

    private Object obj;

    Box(Object obj) {
        this.obj = obj;
    }

    Object getObj() {
        return obj;
    }

    void setObj(Object obj) {
        this.obj = obj;
    }

    void info(){
        System.out.println("Object: " + obj);
        System.out.println("Type: " + obj.getClass());
    }
}

class BoxUltimate<T> {
    private T obj;

    BoxUltimate(T obj) {
        this.obj = obj;
    }

    T getObj() {
        return obj;
    }

    void setObj(T obj) {
        this.obj = obj;
    }

    void info() {
        System.out.println("Object: " + obj);
        System.out.println("Type: " + obj.getClass());
    }
}

class Main {
    public static void main(String[] args) {

        Box box1 = new Box(1);
        Box box2 = new Box("str");

        box1.info();
        box2.info();

        int x = 10;

        x = x + (Integer) box2.getObj();
        System.out.println("x = " + x);

    }
}
