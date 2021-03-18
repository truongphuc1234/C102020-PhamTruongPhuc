package spring.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home/home";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "/login/login";
    }

    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }
}
