package com.example.apirouting.firstOne.Service;
import org.springframework.stereotype.Service;
@Service
public class MyService {
    public String getResult(){
        return "Home Page";
    }
    public String getResult2(){
        return "About Page";
    }
}
