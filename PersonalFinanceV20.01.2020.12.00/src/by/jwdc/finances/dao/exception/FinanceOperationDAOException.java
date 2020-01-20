package by.jwdc.finances.dao.exception;

public class FinanceOperationDAOException extends Exception {
    public FinanceOperationDAOException() {
    }

    public FinanceOperationDAOException(String message) {
        super(message);
    }

    public FinanceOperationDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FinanceOperationDAOException(Throwable cause) {
        super(cause);
    }
}
