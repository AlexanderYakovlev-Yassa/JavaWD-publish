package by.jwdc.finances.service.exception;

public class ServiceFinanceOperationAlreadyExistException extends Exception {

    public ServiceFinanceOperationAlreadyExistException() {
    }

    public ServiceFinanceOperationAlreadyExistException(String message) {
        super(message);
    }

    public ServiceFinanceOperationAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceFinanceOperationAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
