package by.jwdc.finances.bean;

import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import org.junit.Test;

import java.util.GregorianCalendar;

public class FinanceOperationTest {

    private static final GregorianCalendar date = new GregorianCalendar();
    private static final OperationType type = new OperationType("earn", true);
    private static final FinanceOperation o1 = new FinanceOperation(date, type, 100.00);

    @Test
    public void testToString() {

        System.out.println(o1.toString());
    }
}