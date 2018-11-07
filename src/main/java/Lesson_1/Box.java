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

class TwoGen<T,V> {

    private T obj1;
    private V obj2;

    public TwoGen(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }

     public void showTypes() {
         System.out.println("Type: " + obj1.getClass().getName());
         System.out.println("Type: " + obj2.getClass().getName());
     }
}

class Stats <T extends Number> {
    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum/nums.length;
    }

    public boolean sameAvg(Stats<?> another){
        return Math.abs(this.avg() - another.avg()) < 0.01;
    }
}

class Main {
    public static void main(String[] args) {

        Integer[] imass = {1,2,3,4,6};
        Double[] dmass = {1.0,2.0,3.0,5.0,6.0};

        Stats<Integer> iStats = new Stats<Integer>(imass);
        Stats<Double> dStats = new Stats<Double>(dmass);

        if(iStats.sameAvg(dStats)) {
            System.out.println("Average values are equal.");
        } else {
            System.out.println("Average values are not equal.");
        }

//        String[] imass = {"","2","3.0","4.0","5.0"};
//        Stats<String> iStats = new Stats<>(imass);
//
//        double res = iStats.avg();
//        System.out.println(res);


//        TwoGen<Integer,String> twoGen = new TwoGen<Integer, String>(555,"Hello");
//
//        twoGen.showTypes();
//
//        int intValue = twoGen.getObj1();
//        String strValue = twoGen.getObj2();
//
//        System.out.println(intValue);
//        System.out.println(strValue);


//        Box box1 = new Box(1);
//        Box box2 = new Box("str");
//
//        box1.info();
//        box2.info();
//
//        int x = 10;
//
//        x = x + (Integer) box2.getObj();
//        System.out.println("x = " + x);

//        BoxUltimate<String> bstr = new BoxUltimate<String>("Hello");
//        BoxUltimate<Integer> bint = new BoxUltimate<Integer>(10);
//
//        bstr.info();
//        bint.info();
//
////        int x = 10;
////        x = x + (Integer) bstr.getObj();
//
//        if (bstr instanceof  BoxUltimate) {
//            System.out.println(1);
//        }
//        if (bint instanceof  BoxUltimate) {
//            System.out.println(2);
//        }
    }
}

