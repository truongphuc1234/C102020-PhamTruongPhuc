package com.dictionary.controller;


import com.dictionary.service.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private Dictionary service;

    @GetMapping("/")
    public String goHomePage() {
        return "/index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String word, Model model){
        String result = service.search(word);
        model.addAttribute("result",result);
        return "/result";
    }

}
