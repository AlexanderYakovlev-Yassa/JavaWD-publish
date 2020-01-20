package by.jwdc.finances.bean.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FinanceOperation implements Serializable {

    private GregorianCalendar date;
    private OperationType type;
    private double value;

    public FinanceOperation(GregorianCalendar date, OperationType type, double value) {

        this.date = date;
        this.type = type;
        this.value = value;
    }

    public FinanceOperation() {
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        FinanceOperation financeOperation = (FinanceOperation) obj;
        return date.equals(financeOperation.date) &&
                type.equals(financeOperation.type) &&
                (int) (value * 100) == (int) (financeOperation.value * 100);
    }

    @Override
    public int hashCode() {
        int res = 7;
        int prime = 31;

        res = res * prime + (date == null ? 0 : date.hashCode());
        res = res * prime + (type == null ? 0 : type.hashCode());
        res = res * prime + (int) (value * 100);

        return res;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                " date=" + date.get(Calendar.DAY_OF_MONTH) + "-" + date.get(Calendar.MONTH) +
                "-" + date.get(Calendar.YEAR) + "-" + date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ", " +
                " type=" + type + ", " +
                " value=" + value +
                "}";
    }
}


