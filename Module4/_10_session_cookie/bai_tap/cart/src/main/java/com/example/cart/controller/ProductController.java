package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@SessionAttributes("carts")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("carts")
    public Map<Product,Cart> setUpCart() {
        return new HashMap<>();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/product_list")
    public String productList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("products", productService.findAll(pageable));
        return "product_list";
    }

    @GetMapping("/detail/{id}")
    public String productDetail(Model model, @PathVariable("id") int productId){
        model.addAttribute("product",productService.findById(productId));
        return "product_detail";
    }

    @PostMapping("/add_to_cart")
    public String addToCart(@RequestParam(value = "product_id")int id, @ModelAttribute("carts") Map<Product,Cart> carts, Model model){
        productService.addToCart(carts, id);
        model.addAttribute("carts",carts);
        return "redirect:/product_list";
    }

    @GetMapping("/cart_list")
    public String viewCart(@ModelAttribute("carts") Map<Product,Cart> carts, Model model){
        model.addAttribute("carts",carts);
        model.addAttribute("total",productService.getTotal(carts));
        return "cart_view";
    }

    @PostMapping(value = "/update_cart",params = {"delete"})
    public String deleteCart(@ModelAttribute("carts") Map<Product,Cart> carts, @RequestParam("product_id") int id){
        productService.delete(carts,id);
        return "redirect:/cart_list";
    }

    @PostMapping(value = "/update_cart",params = {"update"})
    public String updateCart(@ModelAttribute("carts") Map<Product,Cart> carts,@RequestParam("product_id") int id, @RequestParam("quantity")int quantity){
        productService.update(carts,id, quantity);
        return "redirect:/cart_list";
    }

}
