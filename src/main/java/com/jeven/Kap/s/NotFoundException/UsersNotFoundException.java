package com.jeven.Kap.s.NotFoundException;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Long id){
        super("Could not found product with " + id);
    }

}
