package exception;

public class PriceTooHighException extends Exception {

    public PriceTooHighException(String errorMessage) {
        super(errorMessage);
    }

}
