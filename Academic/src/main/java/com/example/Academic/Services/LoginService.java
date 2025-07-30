package com.example.Academic.Services;

import com.example.Academic.repository.RegisterRepo;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final RegisterRepo registerRepo;

    public LoginService(RegisterRepo registerRepo) {
        this.registerRepo = registerRepo;
    }

    public boolean checkLogin(String email, String password) {
        return registerRepo.findByEmailIgnoreCase(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}

