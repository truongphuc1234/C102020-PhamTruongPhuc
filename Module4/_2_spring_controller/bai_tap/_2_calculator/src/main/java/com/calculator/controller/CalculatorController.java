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
        double number1 = Double.parseDouble(stringNumber1);
        double number2 = Double.parseDouble(stringNumber2);
        switch (operation) {
            case "Addition":
                model.addAttribute("result", calculationService.add(number1, number2));
                break;
            case "Subtraction":
                model.addAttribute("result", calculationService.subtract(number1, number2));
                break;
            case "Multiplication":
                model.addAttribute("result", calculationService.multiply(number1, number2));
                break;
            case "Division":
                if (number2 != 0)
                    model.addAttribute("result", calculationService.divide(number1, number2));
                else
                    model.addAttribute("result", "Number 2 must not be 0");
                break;
            default:
                break;
        }

        model.addAttribute("operation", operation);
        return "index";
    }
}
