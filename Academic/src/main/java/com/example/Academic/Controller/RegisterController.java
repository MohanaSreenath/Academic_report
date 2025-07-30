package com.example.Academic.Controller;


//modules importing
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//class importing
import com.example.Academic.Services.RegisterService;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @GetMapping("/register")
    public String showRegisterPage() {
        return "registerpage"; // 👈 renders registerpage.html
    }
    @PostMapping("/register")
    public String loadRegister(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        boolean flag = false;
        try {
        flag = registerService.registerUser(name, email, password);
        }
        catch (Exception e) {
            System.out.println("Error in register service class");
            return "Problem in the service class";
        }
        return flag ? "loginpage" : "registerpage";
    }

}

