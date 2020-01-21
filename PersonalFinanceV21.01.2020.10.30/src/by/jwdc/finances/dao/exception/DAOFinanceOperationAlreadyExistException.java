package by.jwdc.finances.dao.exception;

public class DAOFinanceOperationAlreadyExistException extends Exception{

    public DAOFinanceOperationAlreadyExistException() {
    }

    public DAOFinanceOperationAlreadyExistException(String message) {
        super(message);
    }

    public DAOFinanceOperationAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOFinanceOperationAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
