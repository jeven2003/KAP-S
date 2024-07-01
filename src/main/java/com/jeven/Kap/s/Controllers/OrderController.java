package com.jeven.Kap.s.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeven.Kap.s.Model.Order;
import com.jeven.Kap.s.NotFoundException.OrderNotFoundException;
import com.jeven.Kap.s.Repository.OrderRepository;

@RestController
public class OrderController {//mamamaya na are

    OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/order")
    public List<Order> getOrder (){
        return repo.findAll();
    }
    @GetMapping("/order/{id}")
     public Order getOrder(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderNotFoundException(id));
    }

    @PostMapping("/order/new")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "A new order is added, Yehey!";
    }
    
    @DeleteMapping ("/order/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "An order is deleted";
    }
    

}
