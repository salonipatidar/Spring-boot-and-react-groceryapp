package com.example.groceryApp.Service;

import com.example.groceryApp.Model.Product;
import com.example.groceryApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll() {

        Iterable<Product> it = productRepository.findAll();

        ArrayList<Product> products = new ArrayList<Product>();
        it.forEach(e -> products.add(e));

        return products;
    }
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }
    public Long count() {

        return productRepository.count();
    }

    public void deleteById(Long prodId) {

        productRepository.deleteById(prodId);
    }

    public Product productSave(Product product) {

        return productRepository.save(product);
    }
    @Override
    public void run(String... strings) throws Exception {
        this.productRepository.save(new Product((long)1,"Beverages", "5 stars", 4,"abc",10,"/images/bevarages.webp",6));
       this.productRepository.save(new Product((long) 2,"Bread/Bakery", "5 stars", 4,"abc",10,"/images/bread.jpg",5));
       // this.productRepository.save(new Product((long)3,"Canned/Jarred items", "5 stars", 4,"abc",10,"/images/jar.jpg"));
        //this.productRepository.save(new Product((long)4,"Dairy Products", "5 stars", 4,"abc",10,"/images/dairy.jpg"));
        //this.productRepository.save(new Product((long)5,"Fruits and Vegetables", "5 stars", 4,"abc",10,"/images/fruitsVege.jpg"));
        //this.productRepository.save(new Product((long)6,"Personal Care", "5 stars", 4,"abc",10,"/images/personalCare.jpg"));
        //this.productRepository.save(new Product((long)7,"Cleaners", "5 stars", 4,"abc",10,"/images/cleaners.jfif"));
        //this.productRepository.save(new Product((long)8,"Household products", "5 stars", 4,"abc",10,"/images/household.jfif"));
    }

}
