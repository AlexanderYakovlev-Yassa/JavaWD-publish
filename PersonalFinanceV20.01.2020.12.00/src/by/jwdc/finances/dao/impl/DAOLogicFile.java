package by.jwdc.finances.dao.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanException;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.exception.BeanNullParametersException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;
import by.jwdc.finances.dao.IDAOLogic;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.dao.exception.DaoUtilException;
import by.jwdc.finances.dao.exception.FinanceOperationDAOException;
import by.jwdc.finances.dao.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class DAOLogicFile implements IDAOLogic {

    private static final File OPERATION_TYPE_FILE = new File("src\\by\\jwdc\\finances\\data\\file\\Operation_types.dat");
    private static final File FINANCE_OPERATION_FILE = new File("src\\by\\jwdc\\finances\\data\\file\\Finance_movement.dat");

    private static final BeanFactory BEAN_FACTORY = BeanFactory.getInstance();
    private static final IBeanLogic BEAN_LOGIC = BEAN_FACTORY.getBeanLogic();

    @Override
    public void fillOperationType(HashSet<OperationType> operationTypes) throws FinanceOperationDAOException, DAOException {

        ArrayList<String> recordsList;

        try {
            recordsList = FileUtil.readFile(OPERATION_TYPE_FILE);
        } catch (DaoUtilException e) {
            throw new FinanceOperationDAOException("Data source error", e);
        }

        OperationType tempOperationType = null;

        for (String s : recordsList) {

            try {
                tempOperationType = BEAN_LOGIC.stringToOperationType(s);
            } catch (BeanNullParametersException e) {
                throw new DAOException("Fail during creation of operation type");
            } catch (BeanWrongParameterException e) {
                throw new DAOException("Fail during creation of operation type");
            }

            operationTypes.add(tempOperationType);
        }
    }

    @Override
    public void saveOperationType() throws DAOException {

        BeanFactory beanFactory = BeanFactory.getInstance();
        IBeanLogic beanLogic = beanFactory.getBeanLogic();
        HashSet<OperationType> allOperationType = null;
        try {
            allOperationType = BEAN_FACTORY.getAllOperationTypes();
        } catch (BeanInitialisationException e) {
            throw new DAOException("Fail to save operation types", e);
        }

        ArrayList<String> stringsOperationType = new ArrayList<String>();

        String tempStringOperationType = null;

        for (OperationType ot : allOperationType){
            tempStringOperationType = beanLogic.OperationTypeToString(ot);
            stringsOperationType.add(tempStringOperationType);
        }

        try {
            FileUtil.rewriteFile(OPERATION_TYPE_FILE, stringsOperationType);
        } catch (DaoUtilException e) {
            throw new DAOException("Fail to save operation types", e);
        }
    }

    @Override
    public HashSet<FinanceOperation> getFinanceOperation() throws DAOException {

        ArrayList<String> financeOperationString = null;
        try {
            financeOperationString = FileUtil.readFile(FINANCE_OPERATION_FILE);
        } catch (DaoUtilException e) {
            throw new DAOException("Fail to get finance operations", e);
        }

        HashSet<FinanceOperation> financeOperations = new HashSet<>();
        FinanceOperation tempFinancelOperation = null;

        for (String s : financeOperationString) {

            try {
                tempFinancelOperation = BEAN_LOGIC.stringToFinanceOperation(s);
            } catch (BeanNullParametersException | BeanWrongParameterException e) {
                throw new DAOException("Fail to get finance operations", e);
            } catch (BeanInitialisationException e) {
                e.printStackTrace();
            } catch (BeanException e) {
                //needs to add operation type to operation type set
            }

            if (tempFinancelOperation != null) {
                financeOperations.add(tempFinancelOperation);
            }
        }

        return financeOperations;
    }

    @Override
    public boolean addFinanceOperation(FinanceOperation financeOperation) throws DAOException {

        String stringFinanceOperation = BEAN_LOGIC.FinanceOperationToString(financeOperation);
        boolean successFlag = false;

        try {
            FileUtil.addRecordToFile(FINANCE_OPERATION_FILE, stringFinanceOperation);
            successFlag = true;
        } catch (DaoUtilException e) {
            throw new DAOException("Fail to add finance operations", e);
        }

        return successFlag;
    }

    @Override
    public boolean deleteFinanceOperation(FinanceOperation financeOperation) {
        return false;
    }

}
