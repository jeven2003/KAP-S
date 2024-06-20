package com.jeven.Kap.s.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeven.Kap.s.Model.UserModel;

@RestController
public class UserController {

    //fetch One Data
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "jeven","jeven@123", "jeven123");

    }
    //fetch multiple data
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Mario", "mario@gmail.com", "mario"));
        users.add(new UserModel(2, "luigi", "luigi@gmail.com", "luigi"));
        users.add(new UserModel(3, "yoshi", "yoshi@gmail.com", "yoshi"));
        return users;
    
    }
    //http:localhost:8080/user/luigi
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(String name){
        return new UserModel(2, "luigi", "luigi@gmail.com", "yoshi");
    } 
}
