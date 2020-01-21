package by.jwdc.finances.controller.Command.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.controller.Command.Command;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.service.IServiceLogic;
import by.jwdc.finances.service.factory.ServiceFactory;

import java.util.HashSet;

public class ShowAllFinanceOperations implements Command {

    @Override
    public String action(String request) {

        ServiceFactory factory = ServiceFactory.getInstance();
        IServiceLogic logic = factory.getServiceLogic();
        BeanFactory beanFactory = BeanFactory.getInstance();
        IBeanLogic beanLogic = beanFactory.getBeanLogic();

        String POSITIVE_RESPONSE = "All the finance operations the base has:\n";
        String NEGATIVE_RESPONSE = "Cant show all finance operations :(";
        String NULL_RESPONSE = "There are no finance operations :(";

        String responce;

        HashSet<FinanceOperation> allFinanceOperations = null;

        try {
            allFinanceOperations = logic.getAllFinanceOperation();
        } catch (DAOException e) {
            responce = NEGATIVE_RESPONSE;
        }

        if (allFinanceOperations == null){
            responce = NULL_RESPONSE;
        }

        StringBuilder sb = new StringBuilder(POSITIVE_RESPONSE);
        String tempString;

        for (FinanceOperation fn : allFinanceOperations){

            tempString = beanLogic.FinanceOperationToString(fn);
            sb.append(tempString + "\n");
        }

        responce = sb.toString();

        return responce;
    }
}
