package com.jeven.Kap.s.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeven.Kap.s.Model.Product;
import com.jeven.Kap.s.Repository.ProductRepository;

@RestController
public class ProductController {

    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getProducts (){
        return repo.findAll();
    }

    /* public Product getProduct(Long id){
        return repo.findById(id);
    }*/

    @PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added, Yehey!";
    }

}
