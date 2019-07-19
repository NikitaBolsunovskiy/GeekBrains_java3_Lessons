import Lesson_6_homework.MainHome6;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AfterFourTestCase {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2},new int[]{4,1,2}},
                {new int[]{2,3},new int[]{98,5,4,4,4,2,3}},
                {new int[]{2,3,5},new int[]{4,4,2,3,5}}
        });
    }

    private int[] mas;
    private int[] res;

    MainHome6 main;

    public AfterFourTestCase(int[] res,int[] mas) {
        this.mas = mas;
        this.res = res;
    }

    @Before
    public void init(){
        main = new MainHome6();
    }

    @Test
    public void AfterFourTesting(){
        Assert.assertArrayEquals(res, main.AfterLastFour(mas));
    }
}

