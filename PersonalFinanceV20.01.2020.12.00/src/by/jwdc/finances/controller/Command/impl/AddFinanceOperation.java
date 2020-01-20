package by.jwdc.finances.controller.Command.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;
import by.jwdc.finances.controller.Command.Command;
import by.jwdc.finances.dao.exception.DAOException;
import by.jwdc.finances.service.IServiceLogic;
import by.jwdc.finances.service.exception.ServiceException;
import by.jwdc.finances.service.factory.ServiceFactory;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddFinanceOperation implements Command {
    @Override
    public String action(String request) {

        ServiceFactory factory = ServiceFactory.getInstance();
        IServiceLogic logic = factory.getServiceLogic();
        BeanFactory beanFactory = BeanFactory.getInstance();
        IBeanLogic beanLogic = beanFactory.getBeanLogic();

        String POSITIVE_RESPONSE = "Finance operation was successfully added:\n";
        String NEGATIVE_RESPONSE = "Can't add this finance operation :(";
        String REGEX = "time=([\\d-:]+)[\\s]" +
                "type=([\\w]+)[\\s]" +
                "value=([\\d]+[/.,]?[\\d]+)";
        //String VALUE_REGEX = "value=([\\d]+[/.]?[\\d]+)";

        String response;

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(request);

        if (!matcher.find()){
            response = "Invalid request format";
        }

        String dateString = matcher.group(1);
        String typeString = matcher.group(2);
        String valueString = matcher.group(3);

        GregorianCalendar date = null;

        try {
            date = beanLogic.stringToDate(dateString);
        } catch (BeanWrongParameterException e) {
            response = "Invalid date-ime format";
        }

        if (date == null){
            response = "Invalid date-ime format";
        }

        OperationType type = null;

        try {
            type = beanLogic.findOperationType(typeString);
        } catch (BeanException e) {
            response = "Operation type is incorrect or missing";
        }

        if (type == null) {
            response = "Operation type is incorrect or missing";
        }

        double value = 0;

        try{
            value = beanLogic.stringToValue(valueString);
        } catch (BeanException e){
            response = "Value is incorrect";
        }

        FinanceOperation financeOperation = new FinanceOperation(date, type, value);

        boolean success = false;

        try {
            success = logic.addFinanceOperation(financeOperation);
        } catch (ServiceException e) {
            response = "Sorry... The finance operation was not added :(";
        }

        if (success){
            response = POSITIVE_RESPONSE;
        } else {
            response = "The finance operation was not added :(";
        }

        return response;
    }
}
