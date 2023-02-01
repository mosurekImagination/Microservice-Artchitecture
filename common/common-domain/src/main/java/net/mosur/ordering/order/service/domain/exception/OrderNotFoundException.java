package net.mosur.ordering.order.service.domain.exception;

public class OrderNotFoundException extends DomainException{
    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
