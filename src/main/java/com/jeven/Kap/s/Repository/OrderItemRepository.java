package com.jeven.Kap.s.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeven.Kap.s.Model.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long>{

}
