package by.jwdc.finances.bean.impl;

import by.jwdc.finances.bean.BeanFactory;
import by.jwdc.finances.bean.IBeanLogic;
import by.jwdc.finances.bean.bean.DateTime;
import by.jwdc.finances.bean.bean.FinanceOperation;
import by.jwdc.finances.bean.bean.OperationType;
import by.jwdc.finances.bean.exception.BeanException;
import by.jwdc.finances.bean.exception.BeanInitialisationException;
import by.jwdc.finances.bean.exception.BeanNullParametersException;
import by.jwdc.finances.bean.exception.BeanWrongParameterException;
import by.jwdc.finances.bean.validator.Validator;

import java.util.HashSet;

public class BeanLogic implements IBeanLogic {

    private static final String WHITE_SPACE = " ";
    private static final String DATE_DELIMITER = "-";
    private static final String TIME_DELIMITER = ":";
    private static final BeanFactory BEAN_FACTORY = BeanFactory.getInstance();

    @Override
    public OperationType stringToOperationType(String string) throws BeanNullParametersException, BeanWrongParameterException {

        final String POSITIVE_SIGN = "+";
        final String NEGATIVE_SIGN = "-";

        if (string == null){
            throw new BeanNullParametersException("Can't create operation type. Null string.");
        }

        String[] field = string.split(WHITE_SPACE);

        if (field.length != 2){
            throw new BeanWrongParameterException("Can't create operation type. Wrong number of parameters.");
        }

        boolean income;
        switch (field[1]){
            case POSITIVE_SIGN: {
                income = true;
                break;
            }
            case NEGATIVE_SIGN: {
                income = false;
                break;
            }
            default:{
                throw new BeanWrongParameterException("Can't create operation type. Wrong 'income' parameter");
            }
        }

        OperationType res = new OperationType(field[0], income);

        return res;
    }

    @Override
    public String OperationTypeToString(OperationType type) {

        if (type == null){
            return null;
        }
        String name = type.getName();
        String sign = type.isIncomeOperation() ? "+" : "-";

        String res = name + WHITE_SPACE + sign;

        return res;
    }

    @Override
    public FinanceOperation stringToFinanceOperation(String string) throws BeanNullParametersException, BeanWrongParameterException, BeanException, BeanInitialisationException {

        Validator validator = Validator.getInstance();

        if (string == null){
            throw new BeanNullParametersException("Can't create operation finance operation. Null string.");
        }

        String[] financeOperationField = string.split(WHITE_SPACE);

        if (financeOperationField.length != 3){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong number of parameters.");
        }

        String[] dateField = financeOperationField[0].split(DATE_DELIMITER);

        if (dateField.length != 4){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong date parameters.");
        }

        String[] timeField = dateField[3].split(TIME_DELIMITER);

        if (timeField.length != 2){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong time parameters.");
        }

        int year;
        int month;
        int day;
        int hour;
        int minute;

        try{
            day = Integer.parseInt(dateField[0]);
            month = Integer.parseInt(dateField[1]);
            year = Integer.parseInt(dateField[2]);
            hour = Integer.parseInt(timeField[0]);
            minute = Integer.parseInt(timeField[1]);
        } catch (NumberFormatException e){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong date-time parameters.");
        }

        if (!validator.isDateCorrect(year, month, day, hour, minute)){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong date-time parameters.");
        }

        DateTime date = new DateTime();
        date.setYear(year);
        date.setMonth(month);
        date.setDay(day);
        date.setHour(hour);
        date.setMinute(minute);

        OperationType type = null;

        try {
            type = findOperationTypeByName(financeOperationField[1]);
        } catch (BeanInitialisationException e) {
            throw e;
        }

        if (type == null){
            //needs to add new operation type to operation type set
            throw new BeanException("No such operation type");
        }

        double value;



        try {
            value = Double.parseDouble(financeOperationField[2]);
        } catch (NumberFormatException e){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong 'value' parameters.");
        }

        FinanceOperation financeOperation = new FinanceOperation(date, type, value);

        return financeOperation;
    }

    @Override
    public String FinanceOperationToString(FinanceOperation financeOperation) {

        String date = dateToString(financeOperation.getDate());
        String type = financeOperation.getType().getName();
        String value = String.format("%.2f",financeOperation.getValue()).replace(',', '.');

        String res = String.format("%s %s %s", date, type, value);

        return res;
    }

    @Override
    public DateTime stringToDate(String string) throws BeanWrongParameterException {

        Validator validator = Validator.getInstance();

        String[] dateField = string.split(DATE_DELIMITER);

        if (dateField.length != 4){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong date parameters.");
        }

        String[] timeField = dateField[3].split(TIME_DELIMITER);

        if (timeField.length != 2){
            throw new BeanWrongParameterException("Can't create finance operation. Wrong time parameters.");
        }

        int year;
        int month;
        int day;
        int hour;
        int minute;

        try{
            day = Integer.parseInt(dateField[0]);
            month = Integer.parseInt(dateField[1]);
            year = Integer.parseInt(dateField[2]);
            hour = Integer.parseInt(timeField[0]);
            minute = Integer.parseInt(timeField[1]);
        } catch (NumberFormatException e){
            throw new BeanWrongParameterException("Wrong date-time parameters.");
        }

        if (!validator.isDateCorrect(year, month, day, hour, minute)){
            throw new BeanWrongParameterException("Wrong date-time parameters.");
        }

        DateTime date = new DateTime();
        date.setYear(year);
        date.setMonth(month);
        date.setDay(day);
        date.setHour(hour);
        date.setMinute(minute);

        return date;
    }

    @Override
    public OperationType findOperationType(String string) throws BeanException {

        if (string == null){
            return null;
        }

        HashSet<OperationType> allTypes = null;
        try {
            allTypes = BEAN_FACTORY.getAllOperationTypes();
        } catch (BeanInitialisationException e) {
            throw new BeanException("Operation type set is not initialised");
        }

        for (OperationType ot : allTypes){
            if (ot.getName().equals(string)){
                return ot;
            }
        }

        return null;
    }

    @Override
    public double stringToValue(String string) throws BeanException {

        string = string.replace(',', '.');
        double value = 0;

        try {
            value = Double.parseDouble(string);
        } catch (NumberFormatException e){
            throw new BeanException("Can't convert to double value");
        }

        if (value <= 0) {

            throw new BeanException("Can't convert to double value");
        }

        return value;
    }

    @Override
    public OperationType newOperationType(String string) {
        return null;
    }

    @Override
    public void addToAllOperationType(OperationType operationType) throws BeanInitialisationException {

        HashSet<OperationType> allTypes = null;
        try {
            allTypes = BEAN_FACTORY.getAllOperationTypes();
        } catch (BeanInitialisationException e) {
            throw e;
        }

        if (!allTypes.add(operationType)){
            for (OperationType ot : allTypes){
                if (ot.equals(operationType)){
                    operationType = ot;
                    break;
                }
            }
        }
    }

    @Override
    public boolean deleteFromAllOperationType(OperationType operationType) {
        return false;
    }



    private OperationType findOperationTypeByName(String name) throws BeanInitialisationException {

        if (name == null){
            return null;
        }

        HashSet<OperationType> allTypes = null;
        try {
            allTypes = BEAN_FACTORY.getAllOperationTypes();
        } catch (BeanInitialisationException e) {
            throw e;
        }

        for (OperationType ot : allTypes){
            if (ot.getName().equals(name)){
                return ot;
            }
        }

        return null;
    }

    private String dateToString(DateTime date){

        //date.set(Calendar.AM_PM, Calendar.PM);

        String year = String.valueOf(date.getYear());
        String moth = String.format("%02d", date.getMonth());
        String day = String.format("%02d", date.getDay());
        String hour = String.format("%02d", date.getHour());
        String minute = String.format("%02d", date.getMinute());

        String res = String.format("%s-%s-%s-%s:%s", day, moth, year, hour, minute);

        return res;
    }
}
