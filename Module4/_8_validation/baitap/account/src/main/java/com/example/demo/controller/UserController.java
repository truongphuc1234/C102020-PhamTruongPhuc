package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("registry")
    public ModelAndView registry(){
        ModelAndView modelAndView = new ModelAndView("registry");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/registry")
    public ModelAndView registry(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("registry");
        }
        userService.save(user);
        return new ModelAndView("results");
    }
}
