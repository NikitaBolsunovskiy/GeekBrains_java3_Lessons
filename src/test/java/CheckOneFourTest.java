import Lesson_6_homework.MainHome6;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckOneFourTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {false,new int[]{2,2,2}},
                {true,new int[]{98,5,4,1,4,2,3}},
                {true,new int[]{1,4,1,3,5}}
        });
    }

    private boolean expected;
    private int[] mas;

    MainHome6 main2;

    public CheckOneFourTest(boolean exp, int[] mas) {
        this.mas = mas;
        this.expected = exp;
    }

    @Before
    public void init(){
        main2 = new MainHome6();
    }

    @Test
    public void CheckOneFourTesting(){
        Assert.assertEquals(expected, main2.CheckOneFour(mas));
    }
}
