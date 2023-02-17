package com.example.registryactivities.exception;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(){
        super("Resource found");
    }

    public ResourceAlreadyExistsException(String message){
        super(message);
    }
}