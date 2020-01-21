package by.jwdc.finances.dao.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.DateTime;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.exception.BeanNullParametersException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;
import by.jwdc.finances.dao.DAOFactory;
import by.jwdc.finances.dao.IDAOLogic;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.dao.exception.DAOFinanceOperationAlreadyExistException;
import by.jwdc.finances.dao.exception.DAOFinanceOperationException;
import by.jwdc.finances.dao.exception.DAOOperationTypeAlreadyExistsException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class DAOLogicTest {

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final IDAOLogic DAO_LOGIC = daoFactory.getDaoLogic();
    private static final BeanFactory BEAN_FACTORY = BeanFactory.getInstance();
    private static final IBeanLogic BEAN_LOGIC = BEAN_FACTORY.getBeanLogic();

    @Test
    public void fillOperationTypeTest() {

        HashSet<OperationType> ALL_OPERATION_TYPES = null;

        try {
            ALL_OPERATION_TYPES = BEAN_FACTORY.getAllOperationTypes();
        } catch (BeanInitialisationException e) {
            e.printStackTrace();
        }

        try {
            DAO_LOGIC.fillOperationType(ALL_OPERATION_TYPES);
        } catch (DAOFinanceOperationException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (OperationType ot : ALL_OPERATION_TYPES) {
            System.out.println(ot);
        }
    }

    @Test
    public void saveOperationTypeTest() {

        String string = "pets1 -";

        OperationType type = null;

        try {
            type = BEAN_LOGIC.stringToOperationType(string);
        } catch (BeanNullParametersException e) {
            System.out.println("NULL EXCEPTION");
        } catch (BeanWrongParameterException e) {
            System.out.println("NULL EXCEPTION");
        }

        try {
            BEAN_LOGIC.addToAllOperationType(type);
        } catch (BeanInitialisationException e) {
            e.printStackTrace();
        }

        try {
            DAO_LOGIC.saveOperationType();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFinanceOperationTest() {

        HashSet<FinanceOperation> financeOperations = null;
        try {
            BEAN_FACTORY.getAllOperationTypes();
        } catch (BeanInitialisationException e) {
            e.printStackTrace();
        }

        try {
            financeOperations = DAO_LOGIC.getFinanceOperation();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        for (FinanceOperation fo : financeOperations) {
            System.out.println(fo);
        }
    }

    @Test
    public void addFinanceOperationTest() {

        HashSet<FinanceOperation> list = null;
        try {
            list = DAO_LOGIC.getFinanceOperation();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        DateTime tempDate;
        int i = 0;
        for (FinanceOperation fo : list) {

            tempDate = fo.getDate();
            tempDate.setMinute(tempDate.getMinute() + 1);
            fo.setDate(tempDate);

            try {
                DAO_LOGIC.addFinanceOperation(fo);
            } catch (DAOException | DAOFinanceOperationAlreadyExistException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void addOperationTypeTest() {

        OperationType newOperationType = new OperationType("newTestType", false);

        Object oldSet = new HashSet<OperationType>();
        try {
            oldSet = BEAN_FACTORY.getAllOperationTypes().clone();
        } catch (BeanInitialisationException e) {
            e.printStackTrace();
        }

        try {
            DAO_LOGIC.addOperationType(newOperationType);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (DAOOperationTypeAlreadyExistsException e) {
            e.printStackTrace();
        }

        Object newSetFromMemory = null;

        try {
            newSetFromMemory = BEAN_FACTORY.getAllOperationTypes().clone();
        } catch (BeanInitialisationException e) {
            e.printStackTrace();
        }

        HashSet<OperationType> newSetFromFile = new HashSet<OperationType>();

        try {
            DAO_LOGIC.fillOperationType(newSetFromFile);
        } catch (DAOFinanceOperationException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        boolean actual = oldSet.equals(newSetFromMemory);
        Assert.assertFalse(actual);

        actual = oldSet.equals(newSetFromFile);
        Assert.assertFalse(actual);
    }
}