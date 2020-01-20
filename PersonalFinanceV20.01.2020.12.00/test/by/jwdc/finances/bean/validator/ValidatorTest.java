package by.jwdc.finances.bean.validator;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    @Test
    public void isDateCorrect() {

        Validator validator = Validator.getInstance();

        boolean case1 = validator.isDateCorrect(2020, 1, 1, 10, 10);
        boolean case2 = validator.isDateCorrect(2020, 12, 1, 10, 10);
        boolean case3 = validator.isDateCorrect(2020, 1, 1, 10, 10);
        boolean case4 = validator.isDateCorrect(2020, 1, 31, 10, 10);
        boolean case5 = validator.isDateCorrect(2020, 2, 29, 10, 10);
        boolean case6 = validator.isDateCorrect(2020, 12, 1, 24, 10);
        boolean case7 = validator.isDateCorrect(2020, 12, 1, 0, 10);
        boolean case8 = validator.isDateCorrect(2020, 12, 1, 10, 0);
        boolean case9 = validator.isDateCorrect(2020, 12, 1, 10, 59);
        boolean case10 = validator.isDateCorrect(2020, 12, 1, 10, 60);
        boolean case11 = validator.isDateCorrect(202025014, 12, 1, 10, 10);

        Assert.assertEquals(true, case1);
        Assert.assertEquals(true, case2);
        Assert.assertEquals(true, case3);
        Assert.assertEquals(true, case4);
        Assert.assertEquals(true, case5);
        Assert.assertEquals(true, case6);
        Assert.assertEquals(true, case7);
        Assert.assertEquals(true, case8);
        Assert.assertEquals(true, case9);
        Assert.assertEquals(false, case10);
        Assert.assertEquals(true, case11);
    }
}