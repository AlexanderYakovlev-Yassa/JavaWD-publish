package by.jwdc.finances.dao;

//import by.jwdc.finances.dao.impl.FileFinanceOperationDAO;

import by.jwdc.finances.dao.impl.DAOLogicFile;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private static final IDAOLogic daoLogic = new DAOLogicFile();

    //private final IFinanceOperationDAO operationDAO = new FileFinanceOperationDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public IDAOLogic getDaoLogic(){
        return daoLogic;
    }

    /*public IFinanceOperationDAO getOperationDAO() {
        return operationDAO;
    }*/
}
