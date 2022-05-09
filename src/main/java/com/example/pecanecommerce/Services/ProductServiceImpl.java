package com.example.pecanecommerce.Services;

import com.example.pecanecommerce.Models.Product;
import com.example.pecanecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    }

