package com.jeven.Kap.s.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeven.Kap.s.Model.UserModel;

@RestController
public class UserController {

    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "jeven","jeven@123", "jeven123");

    }
    
}
