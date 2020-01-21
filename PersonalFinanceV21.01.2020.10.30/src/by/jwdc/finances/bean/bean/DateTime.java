package by.jwdc.finances.bean.bean;

import java.io.Serializable;
import java.util.Objects;

public class DateTime implements Serializable, Comparable<DateTime> {
    int year;
    int month;
    int day;
    int hour;
    int minute;

    public DateTime() {
    }

    public DateTime(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }


    @Override
    public int compareTo(DateTime o) {
        if (o == null){
            return -1;
        }

        int res = this.year - o.year;
        if(res != 0){
            return res;
        }
        res = this.month - o.month;
        if(res != 0){
            return res;
        }
        res = this.day - o.day;
        if(res != 0){
            return res;
        }
        res = this.hour - o.hour;
        if(res != 0){
            return res;
        }
        return  this.minute - o.minute;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (this == o) {
            return true;
        }
        if ((o.getClass() != this.getClass())) {
            return false;
        }

        DateTime dateTime = (DateTime) o;
        return compareTo(dateTime) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 7;

        res = res * prime + year;
        res = res * prime + month;
        res = res * prime + day;
        res = res * prime + hour;
        res = res * prime + minute;

        return res;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}
