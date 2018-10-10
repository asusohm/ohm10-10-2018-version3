package sut.sa.g15.exception;

public class ServiceCenterNotFoundException extends RuntimeException {
    public ServiceCenterNotFoundException() {
        super("Exception : ServiceCenter NotFound");
    }
}
