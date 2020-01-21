package by.jwdc.finances.dao.exception;

public class DAOFinanceOperationException extends Exception {
    public DAOFinanceOperationException() {
    }

    public DAOFinanceOperationException(String message) {
        super(message);
    }

    public DAOFinanceOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOFinanceOperationException(Throwable cause) {
        super(cause);
    }
}
