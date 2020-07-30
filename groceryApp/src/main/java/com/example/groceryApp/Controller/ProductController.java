package com.example.groceryApp.Controller;

import com.example.groceryApp.Model.Product;
import com.example.groceryApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){

        return productService.productSave(product);
    }

    @GetMapping("/products")
    public List<Product> allProducts() {

        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> ProductByID(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        return productService.findById(userId);
    }

    @GetMapping("/products/count")
    public Long count() {

        return productService.count();
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        productService.deleteById(userId);
    }
}
