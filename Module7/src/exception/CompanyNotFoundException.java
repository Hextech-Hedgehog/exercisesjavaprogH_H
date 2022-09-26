package exception;

public class CompanyNotFoundException extends Exception {
    public CompanyNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
