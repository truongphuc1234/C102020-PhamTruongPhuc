package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping
    public String goToHomePage(){
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam("condiment") String[] condiments, Model model){
        model.addAttribute("condiments",condiments);
        return "list";
    }
}
