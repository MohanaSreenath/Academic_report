package com.example.Academic.Controller;


//modules importing
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//class importing
import com.example.Academic.Services.RegisterService;

@RestController
public class RegisterController {

  //creating object globally
  RegisterService registerService = new RegisterService();
    @PostMapping("/register")
    public String loadRegister(@RequestParam String name,String email,String password){
        registerService.getUserdetails(name,email,password);
        return "registerpage";
    }
}
