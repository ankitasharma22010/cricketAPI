package com.example.apirouting.firstOne.controller;
import com.example.apirouting.firstOne.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myservice;

    @GetMapping("/")
    public String getHomePage() {
        return myservice.getResult();
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return myservice.getResult2();
    }
}
