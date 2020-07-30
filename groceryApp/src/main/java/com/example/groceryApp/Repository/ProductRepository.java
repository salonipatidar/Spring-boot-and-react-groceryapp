package com.example.groceryApp.Repository;

import com.example.groceryApp.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends CrudRepository<Product,Long> {
}
