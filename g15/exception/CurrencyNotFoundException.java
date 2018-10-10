package sut.sa.g15.exception;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException() {
        super("Exception : Currency NotFound");
    }
}
