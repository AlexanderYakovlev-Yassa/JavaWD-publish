package by.jwdc.finances.bean.bean;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTimeTest {

    @Test
    public void testEquals() {

        DateTime d1 = new DateTime(2020,01,21,9,00);
        DateTime d11 = new DateTime(2020,01,21,9,00);
        DateTime d2 = new DateTime(2020,01,21,9,30);

        boolean actual = d1.equals(d11);
        Assert.assertTrue(actual);

        actual = d1.equals(d2);
        Assert.assertFalse(actual);
    }
}