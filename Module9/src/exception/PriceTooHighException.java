package exception;

public class PriceTooHighException extends PriceException {

    public PriceTooHighException(String errorMessage) {
        super(errorMessage);
    }

}
