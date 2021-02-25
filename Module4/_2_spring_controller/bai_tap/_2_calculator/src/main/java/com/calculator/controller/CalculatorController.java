package com.calculator.controller;

import com.calculator.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculationService calculationService;

    @GetMapping
    public String goToHomePage() {
        return "index";
    }

    @PostMapping
    public String calculate(Model model, @RequestParam("number_1") String stringNumber1, @RequestParam("number_2") String stringNumber2, String operation) {
        model.addAttribute("operation", operation);
        model.addAttribute("result",calculationService.calculate(stringNumber1,stringNumber2,operation));
        return "index";
    }
}
