package sut.sa.g15.exception;

public class InsufficientfundsException extends RuntimeException {
    public InsufficientfundsException() {
        super("Exception : Insufficient Funds");
    }
}
