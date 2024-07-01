package com.jeven.Kap.s.NotFoundException;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id){
        super("Could not found product with " + id);
    }

}
