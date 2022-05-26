package com.example.pecanecommerce.Services;

import com.example.pecanecommerce.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product saveProduct(Product product);
    public Optional<Product> getProductById(Integer id);
    public void updateProduct(Product product);
    public void deleteProduct(Integer id);
    public List<Product> findAll();
}
