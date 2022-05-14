package com.example.pecanecommerce.Controllers;

import com.example.pecanecommerce.Models.Product;
import com.example.pecanecommerce.Models.User;
import com.example.pecanecommerce.Services.ProductService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String show() {

        return "products/show";
    }

    @GetMapping("/create")
    public String create(Product product) {

        return "products/create";
    }
    @PostMapping("/save")
    public String save(Product product ){
        LOGGER.info("This is the product:{}", product);
        User user = new User(1, "","","","","","");
        product.setUser(user);
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
