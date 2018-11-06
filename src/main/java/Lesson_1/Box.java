package Lesson_1;

public class Box {

    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void info(){
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
