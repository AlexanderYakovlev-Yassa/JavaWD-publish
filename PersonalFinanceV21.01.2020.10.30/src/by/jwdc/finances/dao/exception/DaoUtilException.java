package by.jwdc.finances.dao.exception;

public class DaoUtilException extends Exception{

    public DaoUtilException() {
    }

    public DaoUtilException(String message) {
        super(message);
    }

    public DaoUtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoUtilException(Throwable cause) {
        super(cause);
    }
}
