package com.yourname.qa.week2;

public class Greeter {

    public String hello(String name) throws IllegalArgumentException{
        if(name.isBlank())
            throw new IllegalArgumentException("Name cannot be blank");

        return "Hello, " + name;
    }
}