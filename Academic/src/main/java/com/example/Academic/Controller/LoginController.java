package com.example.Academic.Controller;

import com.example.Academic.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService  loginService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loadLogin() {
        return "loginpage";
    }

    @PostMapping("/login")
    public String loginCheck(@RequestParam("email") String email, @RequestParam("password") String password){
        boolean flag = loginService.checkLogin(email,password);
        return flag? "WelcomePage" : "loginpage";
    }
}



