package sut.sa.g15.exception;

public class DepositNotFoundException extends RuntimeException {
    public DepositNotFoundException() {
        super("Exception : Deposit NotFound");
    }
}
