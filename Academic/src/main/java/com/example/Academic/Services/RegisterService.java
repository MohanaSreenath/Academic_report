package com.example.Academic.Services;

//importing classes
import com.example.Academic.entity.*;

public class RegisterService {
    public String getUserdetails(String name,String email,String password){
        saveDetails(name,email,password);
        return "hello world";
    }
}