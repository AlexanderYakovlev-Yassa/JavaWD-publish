package by.jwdc.finances.bean.exception;

public class BeanNullParametersException extends Exception{

    public BeanNullParametersException() {
    }

    public BeanNullParametersException(String message) {
        super(message);
    }

    public BeanNullParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanNullParametersException(Throwable cause) {
        super(cause);
    }
}
