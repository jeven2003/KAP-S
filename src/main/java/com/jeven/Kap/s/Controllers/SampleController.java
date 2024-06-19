package com.jeven.Kap.s.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello-world")
    public String helloworld(){
        return "Hello World";
    }
}
