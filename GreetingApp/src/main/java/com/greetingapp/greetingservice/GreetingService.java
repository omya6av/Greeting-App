package com.greetingapp.greetingservice;


import com.greetingapp.model.Greeting;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //UC4
    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String firstName, String lastName){
        String message = getPersonalizedMessage(firstName, lastName);
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

}
