package com.BookStore.controller;

import com.BookStore.model.Customer;
import org.springframework.web.bind.annotation.*;
import com.BookStore.dto.CustomerDTO;
import com.BookStore.mapper.CustomerMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final List<Customer> customers = new ArrayList<>();
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customers.add(customer);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/customers/" + customer.getId());
        
        return new ResponseEntity<>(customerMapper.customerToCustomerDTO(customer), headers, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public Customer registerCustomer(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            @RequestParam("address") String address) {

        Customer customer = new Customer();
        customer.setId((long) (customers.size() + 1)); // Simple ID assignment for demonstration
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);

        customers.add(customer);
        return customer;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
