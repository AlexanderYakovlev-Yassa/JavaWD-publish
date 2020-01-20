package by.jwdc.finances.bean.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanException;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.exception.BeanNullParametersException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;
import by.jwdc.finances.dao.DAOFactory;
import by.jwdc.finances.dao.IDAOLogic;
import by.jwdc.finances.dao.exception.DAOException;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashSet;

public class BeanLogicTest {

    private static BeanFactory factory = BeanFactory.getInstance();
    private static IBeanLogic BEAN_LOGIC = factory.getBeanLogic();
    private static DAOFactory daoFactory = DAOFactory.getInstance();
    private static IDAOLogic DAO_LOGIC = daoFactory.getDaoLogic();


    @Test
    public void stringToOperationTypeTest() {

        String string = "earn +";

        OperationType type = null;

        try {
            type = BEAN_LOGIC.stringToOperationType(string);
        } catch (BeanNullParametersException e) {
            System.out.println("NULL EXCEPTION");
        } catch (BeanWrongParameterException e) {
            System.out.println("NULL EXCEPTION");
        }

        System.out.println(type);

    }

    @Test
    public void toFinanceOperationTest() {

        String string = "20-02-2020-20:00 earn 200";

        FinanceOperation financeOperation = null;

        try {
            financeOperation = BEAN_LOGIC.stringToFinanceOperation(string);
        } catch (BeanNullParametersException e) {
            System.out.println("NULL EXCEPTION");
            e.printStackTrace();
        } catch (BeanWrongParameterException e) {
            System.out.println("NULL EXCEPTION");
            e.printStackTrace();
        } catch (BeanInitialisationException e) {
            e.printStackTrace();
        } catch (BeanException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

   /* @Test
    public void dateToStringTest() {

        GregorianCalendar date = new GregorianCalendar();

        BeanLogic beanLogic = new BeanLogic();

        String strDate = beanLogic.dateToString(date);

        System.out.println(strDate);
    }*/

    @Test
    public void FinanceOperationToStringTest() {

        HashSet<FinanceOperation> financeOperation = null;

        try {
            financeOperation = DAO_LOGIC.getFinanceOperation();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (FinanceOperation fo : financeOperation){
            System.out.println(BEAN_LOGIC.FinanceOperationToString(fo));
        }
    }

    @Test
    public void stringToDateTest() {

        String dateString = "20-01-2020-12:00";

        GregorianCalendar date = null;

        try {
            date = BEAN_LOGIC.stringToDate(dateString);
        } catch (BeanWrongParameterException e) {
            e.printStackTrace();
        }

        System.out.println(date.toString());
    }
}