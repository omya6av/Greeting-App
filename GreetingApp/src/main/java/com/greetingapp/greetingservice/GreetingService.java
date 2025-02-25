package com.greetingapp.greetingservice;


import com.greetingapp.model.Greeting;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String firstName, String lastName) {
        String message = getPersonalizedMessage(firstName, lastName);
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    //UC5
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found ID : " + id));
    }

    //UC6
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

}
