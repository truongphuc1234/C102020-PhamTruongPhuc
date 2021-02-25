package com.email.controller;

import com.email.model.EmailSetting;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@ComponentScan("com.email")
public class EmailController {
    private final String[] countries = new String[]{"English","Vietnamese","Japanese","Chinese"};
    private final int[] pageSizes = new int[]{5,10,25,50,100};
    private EmailSetting setting;

    @GetMapping("/")
    public String home(Model model){
        setting = new EmailSetting("Vietnamese",10,true, "sfddgfg");
        model.addAttribute("setting",setting);
        return "home";
    }

    @GetMapping("/setting")
    public String settingForm(Model model){
        model.addAttribute("setting",setting);
        model.addAttribute("countries",countries);
        model.addAttribute("pageSizes",pageSizes);
        return "setting";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("setting") EmailSetting setting){
        this.setting = setting;
        return "home";
    }
}
