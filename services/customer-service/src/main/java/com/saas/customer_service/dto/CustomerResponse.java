package com.saas.customer_service.dto;

import com.saas.customer_service.model.Address;
import lombok.Data;


@Data
public class CustomerResponse {

    String id;
    String firstName;
    String lastName;
    String email;

    Address address;
}
