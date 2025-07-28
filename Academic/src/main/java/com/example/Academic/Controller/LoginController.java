package com.example.Academic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loadLogin() {
        return "loginpage";
    }
}



