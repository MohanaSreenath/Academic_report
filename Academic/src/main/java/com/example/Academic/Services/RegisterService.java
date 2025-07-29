package com.example.Academic.Services;

//importing classes
import com.example.Academic.dto.*;
import com.example.Academic.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepo registerRepo;

    public Register getUserdetails(String name,String email,String password){
        Register register = new Register();
        register.setName(name);
        register.setEmail(email);
        register.setPassword(password);
        return registerRepo.save(register);
    }
}