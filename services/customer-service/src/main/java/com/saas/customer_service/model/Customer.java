package com.saas.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document


public class Customer {

    @Id
    private String id;
    private String name;
    private String firstName;
    private  String lastName;
    private String email;
    private Address address;





}
