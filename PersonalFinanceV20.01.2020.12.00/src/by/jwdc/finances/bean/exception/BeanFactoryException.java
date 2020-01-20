package by.jwdc.finances.bean.exception;

public class BeanFactoryException extends Exception {
    public BeanFactoryException() {
    }

    public BeanFactoryException(String message) {
        super(message);
    }

    public BeanFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanFactoryException(Throwable cause) {
        super(cause);
    }
}
