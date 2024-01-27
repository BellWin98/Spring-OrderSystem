package com.hanhwa.project.OrderSystem.domain.order.repository;

import com.hanhwa.project.OrderSystem.domain.order.entity.Order;
import com.hanhwa.project.OrderSystem.domain.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
