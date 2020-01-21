package by.jwdc.finances.bean;

import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.impl.BeanLogic;
import by.jwdc.finances.dao.DAOFactory;
import by.jwdc.finances.dao.IDAOLogic;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.dao.exception.DAOFinanceOperationException;

import java.util.HashSet;

public class BeanFactory {

    private static final BeanFactory instance = new BeanFactory();
    private static final HashSet<OperationType> ALL_OPERATION_TYPES = new HashSet<OperationType>();
    private static final IBeanLogic beanLogic = new BeanLogic();

    private BeanFactory(){}

    public static BeanFactory getInstance(){
        return instance;
    }

    public IBeanLogic getBeanLogic(){
        return beanLogic;
    }

    public HashSet<OperationType> getAllOperationTypes() throws BeanInitialisationException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        IDAOLogic daoLogic = daoFactory.getDaoLogic();

        if (ALL_OPERATION_TYPES.isEmpty()){
            try {
                daoLogic.fillOperationType(ALL_OPERATION_TYPES);
            } catch (DAOFinanceOperationException e) {
                throw new BeanInitialisationException("Fail initialisation of operation type list", e);
            } catch (DAOException e) {
                throw new BeanInitialisationException("Fail initialisation of operation type list", e);
            }
        }

        return ALL_OPERATION_TYPES;
    }

}
