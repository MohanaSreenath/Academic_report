package com.example.Academic.Controller;


//modules importing
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//class importing
import com.example.Academic.Services.RegisterService;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @GetMapping("/register")
    public String showRegisterPage() {
        return "registerpage"; // 👈 renders registerpage.html
    }
    @PostMapping("/register")
    public String loadRegister(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

        boolean flag = registerService.registerUser(name, email, password);
        return flag ? "loginpage2" : "registerpage";
    }

}

