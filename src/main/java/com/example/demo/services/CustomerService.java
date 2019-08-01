package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public Customer createCustomer(String firstName, String lastName, int age, boolean nebunLaCap){
        Customer createdCustomer=Customer.builder().firstName(firstName)
                                                    .lastName(lastName)
                                                    .age(age)
                                                    .nebunLaCap(nebunLaCap).build();
        customerRepository.save(createdCustomer);
        return createdCustomer;
    }
    public Customer findCustomer(int id){
        Optional<Customer> finded = customerRepository.findById(id);

        if(finded.isPresent())return finded.get();
        throw new CustomerNotFoundException("Customer",id);
    }
    public String deleteCustomer(int id){
        try {
            customerRepository.deleteById(id);
            return "Customer with id: "+id+" was deleted";
        }
        catch(EmptyResultDataAccessException e){
            throw new CustomerNotFoundException("Customer",id);
        }
    }
}
