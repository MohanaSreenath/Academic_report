package com.example.Academic.Services;

import com.example.Academic.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class LoginService {
    @Autowired
    private final RegisterRepo registerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginService(RegisterRepo registerRepo) {
        this.registerRepo = registerRepo;
    }

    public boolean checkLogin(String email, String password) {
        return registerRepo.findByEmailIgnoreCase(email)
                .map(user -> user.getPassword().equals(passwordEncoder.encode(password)))
                .orElse(false);
    }
}

