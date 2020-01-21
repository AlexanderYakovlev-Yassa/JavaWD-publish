package by.jwdc.finances.dao.exception;

public class DAOOperationTypeAlreadyExistsException extends Exception {

    public DAOOperationTypeAlreadyExistsException() {
    }

    public DAOOperationTypeAlreadyExistsException(String message) {
        super(message);
    }

    public DAOOperationTypeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOOperationTypeAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
