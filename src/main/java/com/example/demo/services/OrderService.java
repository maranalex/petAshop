package com.example.demo.services;

import com.example.demo.entities.Breed;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Dog;
import com.example.demo.entities.Order;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CustomerService customerService;
    private BreedService breedService;
    private DogService dogService;

    @Autowired
    public OrderService(OrderRepository orderRepository,CustomerService customerService, BreedService breedService, DogService dogService){
        this.orderRepository=orderRepository;
        this.customerService=customerService;
        this.breedService=breedService;
        this.dogService=dogService;
    }



    public Order createOrder(int customerId,int dogId){
        Customer customer=customerService.findCustomer(customerId);
        Dog dog=dogService.findDog(dogId);


        Order createdOrder=Order.builder().customer(customer).dog(dog).orderDate(LocalDateTime.now()).delivered(false).build();
        orderRepository.save(createdOrder);
        return createdOrder;
    }

}
