package com.saas.customer_service.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException{


    private String customerId;

    public CustomerNotFoundException(String customerId) {
        super("Customer with ID " + customerId + " not found.");
        this.customerId = customerId;
    }

}
