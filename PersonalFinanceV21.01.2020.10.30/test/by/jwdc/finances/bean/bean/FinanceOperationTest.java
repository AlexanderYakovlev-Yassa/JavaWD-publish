package by.jwdc.finances.bean.bean;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinanceOperationTest {

    @Test
    public void testEqualsTest() {

        DateTime d1 = new DateTime(2020,01,21,9,00);
        DateTime d11 = new DateTime(2020,01,21,9,00);
        DateTime d2 = new DateTime(2020,01,21,9,30);

        OperationType t1 = new OperationType("type1", true);
        OperationType t11 = new OperationType("type1", true);
        OperationType t2 = new OperationType("type2", false);

        FinanceOperation f1 = new FinanceOperation(d1, t1, 100);
        FinanceOperation f11 = new FinanceOperation(d11, t1, 100);
        FinanceOperation f2 = new FinanceOperation(d2, t2, 200);

        boolean actual = f1.equals(f11);
        Assert.assertTrue(actual);

        actual = f1.equals(f1);
        Assert.assertTrue(actual);

        actual = f1.equals(f2);
        Assert.assertFalse(actual);


    }
}