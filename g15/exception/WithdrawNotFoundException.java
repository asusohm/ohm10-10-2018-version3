package sut.sa.g15.exception;

public class WithdrawNotFoundException extends RuntimeException {
    public WithdrawNotFoundException() {
        super("Exception : Withdraw NotFound");
    }
}
