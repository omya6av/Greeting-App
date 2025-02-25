package com.greetingapp.greetingservice;


import org.springframework.stereotype.Service;


//UC2
@Service
public class GreetingService {
    public String getGreeting(){
        return "Hello world";
    }
}
