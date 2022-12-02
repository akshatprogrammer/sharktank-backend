package com.example.xharktank3.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    /*Just a greeting getmapping to test the server is running fine */
    @GetMapping("/greeting")
    public String helloWorld(){
        return "Hello Sharks and Entrepruener!";
    }
}
