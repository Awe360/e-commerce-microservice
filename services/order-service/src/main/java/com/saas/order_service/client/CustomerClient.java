package com.saas.order_service.client;


import com.saas.order_service.dto.clientDto.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service"
)
public interface CustomerClient {

    @GetMapping("/customer-id")
    Optional<CustomerResponse> getCustomerById(@PathVariable("customer-id") String customerId);



}
