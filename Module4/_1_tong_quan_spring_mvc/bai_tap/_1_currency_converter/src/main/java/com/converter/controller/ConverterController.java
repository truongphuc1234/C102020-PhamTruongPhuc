package com.converter.controller;

import com.converter.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConverterController {
    @Autowired
    private Converter converter;

    @GetMapping("/")
    public String goHome(){
        return "/home";
    }

    @PostMapping("/converter")
    public ModelAndView convert(@RequestParam String usd, @RequestParam String rate) {

        ModelAndView model = new ModelAndView("/result");
        double usdNumber= Double.parseDouble(usd);
        double rateNumber= Double.parseDouble(rate);
        double result = converter.convert(usdNumber,rateNumber);
        model.addObject("result",result);
        return model;
    }
}
