package com.example.pecanecommerce.Controllers;

import com.example.pecanecommerce.Models.Product;
import com.example.pecanecommerce.Models.User;
import com.example.pecanecommerce.Services.ProductService;
import com.example.pecanecommerce.Services.UploadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create(Product product) {
        return "products/create";
    }
    @PostMapping("/save")
    public String save(Product product, @RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("This is the product:{}", product);
        User user = new User(1, "","","","","","");
        product.setUser(user);

        if(product.getId() ==null){
            String nameImage = upload.saveImage(file);
            product.setImage(nameImage);
        } else {


        }

        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = new Product();
        Optional<Product> optionalProduct = productService.getProductById(id);
        product = optionalProduct.get();

        LOGGER.info("This is the product:{}", product);
        model.addAttribute("product", product);
        return "products/edit";
    }
    @GetMapping("/update")
    public String update(Product product, @RequestParam("img") MultipartFile file) throws IOException {
        Product p = new Product();
        p = productService.getProductById(product.getId()).get();
        if(file.isEmpty()){
            product.setImage(p.getImage());
        } else {// when edit the image of the product
            if(!p.getImage().equals("default.jpg")){
                upload.deleteImage(p.getImage());
            }
            String nameImage = upload.saveImage(file);
            product.setImage(nameImage);
        }
        product.setUser(p.getUser());
        productService.updateProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Product p = new Product();
        p = productService.getProductById(id).get();

        if(!p.getImage().equals("default.jpg")){
            upload.deleteImage(p.getImage());
        }
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
