package com.jeven.Kap.s.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeven.Kap.s.Model.OrderItem;
import com.jeven.Kap.s.NotFoundException.OrderItemNotFoundException;
import com.jeven.Kap.s.Repository.OrderItemRepository;

@RestController
public class OrderItemController {

    OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/orderitem")
    public List<OrderItem> getOrderItem (){
        return repo.findAll();
    }
    @GetMapping("/orderitem/{id}")
     public OrderItem getOrderItem(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderItemNotFoundException(id));
    }

    @PostMapping("/orderitem/new")
    public String addOrderItem(@RequestBody OrderItem newOrderItem){
        repo.save(newOrderItem);
        return "A new order item is added, Yehey!";
    }
    
    @DeleteMapping ("/orderitem/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id){
        repo.deleteById(id);
        return "An order item is deleted";
    }
    

}
