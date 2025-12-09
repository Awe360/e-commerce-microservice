package com.saas.customer_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Validated
public class Address {

    private String street;
    private String houseNumber;
    private String state;
    private String zipCode;
}
