package com.example.pecanecommerce.Controllers;

import com.example.pecanecommerce.Models.Product;
import com.example.pecanecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String admin(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "Admin/home";
    }
}
