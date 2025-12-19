package com.saas.order_service.dto.clientDto;

import lombok.Data;

@Data
public class CustomerResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
