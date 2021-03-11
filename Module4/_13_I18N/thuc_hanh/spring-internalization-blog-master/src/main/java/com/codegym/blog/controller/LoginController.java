package com.codegym.blog.controller;

import com.codegym.blog.request.Credential;
import com.codegym.blog.response.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

  @GetMapping("/login")
  public String login(@ModelAttribute("credential") Credential credential) {
    return "login";
  }

  @PostMapping("/login")
  public String dashboard(@ModelAttribute("credential") Credential credential, Model model) {
    User user = new User();
    user.setUserName(credential.getUsername());
    model.addAttribute("user", user);
    return "redirect:dashboard";
  }

}
