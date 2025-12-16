package com.saas.order_service.exception;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message) {
        super(message);
    }
}
