package com.saas.customer_service.mapper;

import com.saas.customer_service.dto.CustomerRequest;
import com.saas.customer_service.dto.CustomerResponse;
import com.saas.customer_service.model.Customer;
import org.springframework.stereotype.Component;

@Component

public class CustomerMapper {

    public Customer mapToEntity(CustomerRequest customerRequest){
        Customer customer=new Customer();
        customer.setId(customerRequest.getId());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        return customer;
    }

    public CustomerResponse mapToResponse(Customer customer){
        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setAddress(customer.getAddress());
        return customerResponse;
    }

    public CustomerResponse mapUpdateRequest(Customer customer, CustomerRequest customerRequest){

        if(customerRequest.getFirstName()!=null){
            customer.setFirstName(customerRequest.getFirstName());
        }
        if(customerRequest.getLastName()!=null){
            customer.setLastName(customerRequest.getLastName());
        }
        if(customerRequest.getEmail()!=null){
            customer.setEmail(customerRequest.getEmail());
        }
        if(customerRequest.getAddress()!=null){
            customer.setAddress(customerRequest.getAddress());
        }

        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setAddress(customer.getAddress());
        return customerResponse;
    }


}
