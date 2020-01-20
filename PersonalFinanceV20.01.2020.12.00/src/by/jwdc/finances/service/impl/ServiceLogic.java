package by.jwdc.finances.service.impl;

import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.dao.DAOFactory;
import by.jwdc.finances.dao.IDAOLogic;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.service.IServiceLogic;
import by.jwdc.finances.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.HashSet;

public class ServiceLogic implements IServiceLogic {

    private static final DAOFactory DAO_FACTORY = DAOFactory.getInstance();
    private static final IDAOLogic DAO_LOGIC = DAO_FACTORY.getDaoLogic();

    public HashSet<FinanceOperation> getAllFinanceOperation() throws DAOException {

        HashSet<FinanceOperation> res = null;

        try {
            res = DAO_LOGIC.getFinanceOperation();
        } catch (DAOException e) {
            throw new DAOException("Cant get list of finance operations", e);
        }

        return res;
    }

    @Override
    public boolean addFinanceOperation(FinanceOperation financeOperation) throws ServiceException {

        boolean successFlag = false;

        try {
            DAO_LOGIC.addFinanceOperation(financeOperation);
            successFlag = true;
        } catch (DAOException e) {
            throw new ServiceException("fail attempt to add the finance operation");
        }

        return successFlag;
    }


}
