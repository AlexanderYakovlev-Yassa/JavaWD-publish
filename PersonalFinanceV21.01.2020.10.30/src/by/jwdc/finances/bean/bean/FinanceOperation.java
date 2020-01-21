package by.jwdc.finances.bean.bean;

import java.io.Serializable;
import java.util.Calendar;

public class FinanceOperation implements Serializable {

    private DateTime date;
    private OperationType type;
    private double value;

    public FinanceOperation(DateTime date, OperationType type, double value) {

        this.date = date;
        this.type = type;
        this.value = value;
    }

    public FinanceOperation() {
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
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
        FinanceOperation fo = (FinanceOperation) obj;
        return date.equals(fo.date) &&
                type.equals(fo.type) &&
                (int) (value * 100) == (int) (fo.value * 100);
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
                " date=" + date.getMonth() + "-" + date.getDay() +
                "-" + date.getYear() + "-" + date.getHour() + ":" + date.getMinute() + ", " +
                " type=" + type + ", " +
                " value=" + value +
                "}";
    }
}


