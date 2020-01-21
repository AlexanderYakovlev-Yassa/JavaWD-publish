package by.jwdc.finances.dao;

import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.dao.exception.DAOFinanceOperationAlreadyExistException;
import by.jwdc.finances.dao.exception.DAOFinanceOperationException;
import by.jwdc.finances.dao.exception.DAOOperationTypeAlreadyExistsException;

import java.util.HashSet;

public interface IDAOLogic {

    void fillOperationType(HashSet<OperationType> allOperationTypes) throws DAOFinanceOperationException, DAOException;

    HashSet<FinanceOperation> getFinanceOperation() throws DAOException;
    boolean addFinanceOperation(FinanceOperation financeOperation) throws DAOException, DAOFinanceOperationAlreadyExistException;
    boolean deleteFinanceOperation(FinanceOperation financeOperation);

    boolean addOperationType(OperationType operationType) throws DAOException, DAOOperationTypeAlreadyExistsException;
    void saveOperationType() throws DAOException;
}