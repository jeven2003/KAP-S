package com.jeven.Kap.s.Controllers;

import java.util.Collections;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeven.Kap.s.DTO.RegistrationRequest;
import com.jeven.Kap.s.Model.Role;
import com.jeven.Kap.s.Model.UserAuth;
import com.jeven.Kap.s.Repository.RoleRepository;
import com.jeven.Kap.s.Repository.UserAuthRepository;

@RestController
@RequestMapping

public class UserAuthController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){
        
        if (userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        }
        if (userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<> ("An account is already registered in this email", HttpStatus.BAD_REQUEST);
        }
       UserAuth user = new UserAuth(
        registrationRequest.getUsername(),
        registrationRequest.getEmail(), 
        passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }
}

