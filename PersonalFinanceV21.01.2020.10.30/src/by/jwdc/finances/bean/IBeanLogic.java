package by.jwdc.finances.bean;

import by.jwdc.finances.bean.bean.DateTime;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanException;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.exception.BeanNullParametersException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;

;

public interface IBeanLogic {

    OperationType stringToOperationType(String string) throws BeanNullParametersException, BeanWrongParameterException;

    String OperationTypeToString(OperationType type);

    FinanceOperation stringToFinanceOperation(String string) throws BeanNullParametersException, BeanWrongParameterException, BeanException, BeanInitialisationException;

    String FinanceOperationToString(FinanceOperation financeOperation);

    DateTime stringToDate(String string) throws BeanWrongParameterException;
    OperationType findOperationType(String string) throws BeanException;
    double stringToValue(String string) throws BeanException;
    OperationType newOperationType(String string);

    void addToAllOperationType(OperationType operationType) throws BeanInitialisationException;
    boolean deleteFromAllOperationType(OperationType operationType);

}
