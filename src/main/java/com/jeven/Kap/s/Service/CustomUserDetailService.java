package com.jeven.Kap.s.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jeven.Kap.s.Model.UserAuth;
import com.jeven.Kap.s.Repository.UserAuthRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

    private UserAuthRepository userauthRepository;

    public CustomUserDetailService(UserAuthRepository userauthRepository) {
        this.userauthRepository = userauthRepository;
    }
    


    public UserDetails loadUserByUsername(String usernameorEmail) throws UsernameNotFoundException{
        UserAuth userauth = userauthRepository.findByUsernameorEmail(usernameorEmail, usernameorEmail).orElseThrow(() ->
            new UsernameNotFoundException("User not found with username or email" + usernameorEmail));

            Set<GrantedAuthority> authorities = userauth
            .getRoles()
            .stream()
            .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

            return new org.springframework.security.core.userdetails.User(
                userauth.getEmail(),
                userauth.getPassword(),
                authorities
                );

        
        }
       

}