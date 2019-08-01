package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int age,
                                   @RequestParam boolean nebunLaCap){

        return customerService.createCustomer(firstName,lastName,age,nebunLaCap);
    }
    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable int id) {
        return customerService.findCustomer(id);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}
