package com.jeven.Kap.s.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeven.Kap.s.Model.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}
