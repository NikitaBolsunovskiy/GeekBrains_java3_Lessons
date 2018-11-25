import Lesson_1.Calculator;
import org.junit.*;

public class Test1 {

    Calculator calculator;

    @Before
    public void init(){
        System.out.println("init");
        calculator = new Calculator();
    }

    @Test
    public void test1(){
        Assert.assertEquals(4, calculator.add(2,2));

    }
    @Test
    public void test2(){
        Assert.assertEquals(5, calculator.add(3,2));

    }
    @Test
    public void test3(){
        Assert.assertEquals(6, calculator.add(4,2));

    }
    @Test
    public void test4(){
        Assert.assertEquals(10, calculator.add(5,6));

    }

    @Test(expected = ArithmeticException.class)
    public void test5(){
        calculator.div(10,0);

    }

    @Test(expected = ArithmeticException.class,timeout = 100)
    @Ignore(value = "Не хочу ждать час!")
    public void test6() {
        try {
            Thread.sleep(90);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calculator.div(10,0);
    }


    @After
    public void shutdown() {
        System.out.println("end");
    }
}
