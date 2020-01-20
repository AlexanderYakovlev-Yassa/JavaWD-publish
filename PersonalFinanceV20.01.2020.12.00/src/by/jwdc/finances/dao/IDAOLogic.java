package by.jwdc.finances.dao;

import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.dao.exception.FinanceOperationDAOException;

import java.util.ArrayList;
import java.util.HashSet;

public interface IDAOLogic {

    void fillOperationType(HashSet<OperationType> allOperationTypes) throws FinanceOperationDAOException, DAOException;
    void saveOperationType() throws DAOException;

    HashSet<FinanceOperation> getFinanceOperation() throws DAOException;
    boolean addFinanceOperation(FinanceOperation financeOperation) throws DAOException;
    boolean deleteFinanceOperation(FinanceOperation financeOperation);
}