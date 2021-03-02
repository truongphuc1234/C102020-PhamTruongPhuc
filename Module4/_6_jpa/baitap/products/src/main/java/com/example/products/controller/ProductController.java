package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("products",productService.getListProduct());
        return "home";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "edit";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "delete";
    }

    @PostMapping("/product/edit")
    public String edit(@ModelAttribute("product") Product product, RedirectAttributes redirect){
        productService.update(product);
        redirect.addFlashAttribute("msg","Update successfully");
        return "redirect:/";
    }

    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("product/create")
    public String create(@ModelAttribute("product") Product product,RedirectAttributes redirect){
        int id = (int) (Math.random()*1000);
        product.setId(id);
        productService.create(product);
        redirect.addFlashAttribute("msg","Create successfully");
        return "redirect:/";
    }

    @PostMapping("product/delete")
    public String delete(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        productService.delete(product.getId());
        redirect.addFlashAttribute("msg","Delete successfully");
        return "redirect:/";
    }
}
