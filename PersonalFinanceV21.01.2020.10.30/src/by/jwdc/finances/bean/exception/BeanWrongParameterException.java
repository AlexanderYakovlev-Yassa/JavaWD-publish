package by.jwdc.finances.bean.exception;

public class BeanWrongParameterException extends Exception {

    public BeanWrongParameterException() {
    }

    public BeanWrongParameterException(String message) {
        super(message);
    }

    public BeanWrongParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanWrongParameterException(Throwable cause) {
        super(cause);
    }
}
