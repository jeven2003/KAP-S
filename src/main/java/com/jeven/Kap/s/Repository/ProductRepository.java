package com.jeven.Kap.s.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeven.Kap.s.Model.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
