package com.saas.customer_service.service;

import com.saas.customer_service.dto.CustomerRequest;
import com.saas.customer_service.dto.CustomerResponse;
import com.saas.customer_service.exception.CustomerNotFoundException;
import com.saas.customer_service.mapper.CustomerMapper;
import com.saas.customer_service.model.Customer;
import com.saas.customer_service.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    public String createCustomer(CustomerRequest request){

        Customer customer= customerMapper.mapToEntity(request);
        customerRepository.save(customer);
        return "Customer created successfully";
    }

    public void  updateCustomer(CustomerRequest request) {
        var customer=customerRepository.findById(request.getId())
                .orElseThrow(()->new CustomerNotFoundException(request.getId()));
        customerMapper.mapUpdateRequest(customer,request);
        customerRepository.save(customer);

    }
    public List<CustomerResponse > getAllCustomers(){
        List<Customer> customers=customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::mapToResponse)
                .toList();
    }

    public CustomerResponse getCustomerById(String id){
        var customer=customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException(id));
        return customerMapper.mapToResponse(customer);
    }

    public void deleteCustomerById(String id){
        customerRepository.deleteById(id);
    }
}
