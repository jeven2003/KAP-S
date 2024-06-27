package com.jeven.Kap.s.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeven.Kap.s.Model.Users;
import com.jeven.Kap.s.NotFoundException.UsersNotFoundException;
import com.jeven.Kap.s.Repository.UsersRepository;

@RestController
public class UsersController {//mamamaya na are

    UsersRepository repo;

    public UsersController(UsersRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/users")
    public List<Users> getUsers (){
        return repo.findAll();
    }
    @GetMapping("/users/{id}")
     public Users getUser(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new UsersNotFoundException(id));
    }

    @PostMapping("/users/new")
    public String addUsers(@RequestBody Users newUsers){
        repo.save(newUsers);
        return "A new user is added, Yehey!";
    }
    //UPDATE ENDPOINTS
    @PutMapping("/users/edit/{id}")
    public Users updateUsers(@PathVariable Long id, @RequestBody Users newUsers){
        return repo.findById(id)
        .map(Users->{
            Users.setname(newUsers.getname());
            Users.setaddress(newUsers.getaddress());
            Users.setemail(newUsers.getemail());
            Users.setage(newUsers.getage());
            return repo.save(Users);
        }).orElseGet(()->{
            return repo.save(newUsers);
        });
    }
    @DeleteMapping ("/users/delete/{id}")
    public String deleteUsers(@PathVariable Long id){
        repo.deleteById(id);
        return "A user is deleted";
    }
    

}
