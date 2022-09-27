package exception;

public class PriceTooLowException extends PriceException {
    public PriceTooLowException (String errorMessage) {
        super(errorMessage);
    }
}
