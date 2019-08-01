package com.example.demo.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String entity,Integer id){
        super(entity+" with id:"+id+" does not exist");
    }
}
