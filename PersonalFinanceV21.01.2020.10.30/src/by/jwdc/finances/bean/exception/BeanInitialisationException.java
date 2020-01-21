package by.jwdc.finances.bean.exception;

public class BeanInitialisationException extends Exception{

    public BeanInitialisationException() {
    }

    public BeanInitialisationException(String message) {
        super(message);
    }

    public BeanInitialisationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanInitialisationException(Throwable cause) {
        super(cause);
    }
}
