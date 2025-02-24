package com.greetingapp.demo;

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
}
