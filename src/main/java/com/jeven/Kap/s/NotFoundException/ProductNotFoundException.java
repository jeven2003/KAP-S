package com.jeven.Kap.s.NotFoundException;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id){
        super("Could not found order with " + id);
    }

}
