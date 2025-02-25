package com.greetingapp.demo;

import com.greetingapp.greetingservice.GreetingService;
import com.greetingapp.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {


    @GetMapping
    public GreetingApp get(){
        return new GreetingApp("Hello world ", "get");
    }

    @PostMapping
    public GreetingApp post(){
        return new GreetingApp("Hello world ", "post");
    }

    @PutMapping
    public GreetingApp put(){
        return new GreetingApp("Hello world", "Put");
    }

    @DeleteMapping
    public GreetingApp delete(){
        return new GreetingApp("Hello world ", "delete");
    }


    //UC2
    private final GreetingService greetingService;   //dependency injection

    @Autowired
    public GreetingController( GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/message")
    public String getGreeting(){
        return greetingService.getGreeting();
    }

    //UC3 //UC4
    @GetMapping("/personalized")
    public String getPersonalizedMessage(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        Greeting savedGreeting = greetingService.saveGreeting(firstName,lastName);
        return greetingService.getPersonalizedMessage(firstName,lastName);
    }




}
