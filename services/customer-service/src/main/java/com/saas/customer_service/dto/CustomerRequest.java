package com.saas.customer_service.dto;

import com.saas.customer_service.model.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequest {
    String id;
    @NotNull(message = "firstName is required")
    String firstName;
    @NotNull(message = "lastName is required")
    String lastName;
    @NotNull(message = "email is required")
    String email;

    Address address;
}
