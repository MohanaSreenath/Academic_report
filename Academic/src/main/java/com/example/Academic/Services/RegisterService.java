package com.example.Academic.Services;

//importing classes
import com.example.Academic.entity.registerEntity;
import com.example.Academic.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepo registerRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(String name, String email, String password) {
        try {
            registerEntity user = new registerEntity();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            registerRepo.save(user);
            return true;
        } catch (Exception e) {
            return false; // email duplicate or some error
        }
    }
}
