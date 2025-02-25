package com.greetingapp.greetingservice;


import org.springframework.stereotype.Service;


//UC2
@Service
public class GreetingService {
    public String getGreeting() {
        return "Hello world";
    }

    //UC3
    public String getPersonalizedMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return "Hello world";
        }
    }

}
