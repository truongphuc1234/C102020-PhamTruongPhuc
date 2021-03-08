package com.codegym.hitcounter.controller;

import com.codegym.hitcounter.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("my_counter")
public class MyCounterController {
    @ModelAttribute("my_counter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("my_counter") MyCounter myCounter){
        myCounter.increment();
        return "index";
    }
}
