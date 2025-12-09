package com.saas.product_service.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductNotFoundException extends RuntimeException{


    private String customerId;

    public ProductNotFoundException(String customerId) {
        super("Customer with ID " + customerId + " not found.");
        this.customerId = customerId;
    }

}
