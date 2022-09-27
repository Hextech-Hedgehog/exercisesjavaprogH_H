package exception;

public class CompanyAlreadyExistsException extends Exception {

    public CompanyAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
