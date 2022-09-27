package palindromes.exceptions;

public class NotAPalindromeException extends RuntimeException {
    public NotAPalindromeException(String message) {
        super(message);
    }
}
