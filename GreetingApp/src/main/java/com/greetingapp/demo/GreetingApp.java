package com.greetingapp.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class GreetingApp {

    private String message;
    private String method;

    public GreetingApp(String message, String method) {
        this.message = message;
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public String getMethod() {
        return method;
    }
}
