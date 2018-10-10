package sut.sa.g15.exception;

public class BalanceNotFoundException extends RuntimeException {
    public BalanceNotFoundException() {
        super("Exception : Balance NotFound");
    }
}
